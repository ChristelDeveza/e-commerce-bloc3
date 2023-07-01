package com.ecommerce.commercial.controller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;

import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.config.JwtConfig;
import com.ecommerce.commercial.model.Product;
import com.ecommerce.commercial.service.ProductService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping(value="/products")
public class ProductController {

  @Autowired
  private ProductService productService;
  
@GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

@GetMapping("{id}")
  public Product getProductById(@PathVariable(name="id") Long id) {
    return productService.getProductById(id);
  }

// @PutMapping("{id}")
//   public void updateProduct(@PathVariable(name="id") Long id, @RequestBody Product product) {
//     productService.updateProduct(id, product);
//   }

// @DeleteMapping("{id}")
//   public void deleteProduct(@PathVariable(name="id") Long id) {
//     productService.deleteProduct(id);
// }

@DeleteMapping("{id}")
public ResponseEntity<String> deleteProduct(@PathVariable(name="id") Long id, HttpServletRequest request) {
    String jwt = request.getHeader("Authorization");
    
    if (jwt == null || jwt.isEmpty()) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
    String newJwt = jwt.replace("Bearer ", "");
    System.out.print(newJwt);
    if (JwtConfig.validateJwt(newJwt)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
    
    productService.deleteProduct(id);
    return ResponseEntity.ok("Produit supprimé avec succès");
}

@GetMapping("/generate-pdf")
public void generatePdf(HttpServletResponse response) throws IOException, URISyntaxException {
    try {
      List<Product> products = productService.getAllProducts();

        // Crée un document PDF
        Document document = new Document();

        // Crée PDF en utilisant la réponse HTTP
        PdfWriter.getInstance(document, response.getOutputStream());

        // Ouvre le document
        document.open();

        // Crée un tableau avec 4 colonnes
        PdfPTable table = new PdfPTable(4);

        // Titre au document avec affichage de la date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(new Date());
        document.add(new Paragraph("Mes produits en promotion à la date du " + currentDate));

        // Permet de créer un espace entre le titre du document et le tableau
        table.setSpacingBefore(20);

        // Ajoute les en-têtes du tableau
        table.addCell("Nom du produit");
        table.addCell("Prix avant promotion");
        table.addCell("Prix après promotion");
        table.addCell("image");


        // Boucle for qui permet d'ajouter les éléments (nom, prix avant promotion, prix après promotion, dans le document)
        for (Product product : products) {
          // Condition : uniquement les produits en promotion
          if(product.getDiscountedPrice() != null) {
            LocalDate date = LocalDate.now();
            if(product.getDiscount().getStartDate().isBefore(date) &&
            (product.getDiscount().getEndDate() == null || product.getDiscount().getEndDate().isAfter(date))) {
            // Ajouter les données du produit dans le document (String.valueOf permet de convertir le nombre en chaîne de caractères)
            table.addCell(new Paragraph(product.getName()));
            table.addCell(new Paragraph(String.valueOf(product.getPrice())));
            table.addCell(new Paragraph(String.valueOf(product.getDiscountedPrice())));
            table.addCell(new Paragraph(product.getImage()));
            
            // String photoPath = product.getPhotosImagePath();
            // System.out.println("Value of photoPath: " + "../resources/static" + photoPath);

            // if(photoPath != null) {
            // Path path = Paths.get(ClassLoader.getSystemResource("commercial/src/main/resources/static" + photoPath).toURI());
            // Image image = Image.getInstance(path.toAbsolutePath().toString());
            // table.addCell(image);
            // }
            }
          }
        
        }

        // Ajout du tableau dans le document
        document.add(table);

        // Ferme le document
        document.close();

        // Définie les en-têtes de la réponse HTTP pour le téléchargement du fichier PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"mon_document.pdf\"");
        response.flushBuffer();

        // Envoie le contenu du fichier PDF généré dans la réponse HTTP
        response.getOutputStream().flush();
    } catch (DocumentException e) {
        // Gére les erreurs liées à la génération du PDF
        e.printStackTrace();
        // Retourne une réponse d'erreur appropriée
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
    
}

}