package com.ecommerce.commercial.controller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;



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
public void generatePdf(HttpServletResponse response) throws IOException {
    try {
      List<Product> products = productService.getAllProducts();

        // Crée un document PDF
        Document document = new Document();

        // Crée PDF en utilisant la réponse HTTP
        PdfWriter.getInstance(document, response.getOutputStream());

        // Ouvre le document
        document.open();

        // Crée un tableau avec 3 colonnes
        PdfPTable table = new PdfPTable(3);

        // Titre au document
        document.add(new Paragraph("Mes produits en promotion"));

        // Ajoute les en-têtes du tableau
        table.addCell("Nom du produit");
        table.addCell("Prix avant promotion");
        table.addCell("Prix après promotion");

        // Boucle for qui permet d'ajouter les éléments (nom, prix avant promotion, prix après promotion, dans le document)
        for (Product product : products) {
          // Condition : uniquement les produits en promotion
          if(product.getDiscountedPrice() != null) {
            // Ajouter les données du produit dans le document (String.valueOf permet de convertir le nombre)
            table.addCell(new Paragraph(product.getName()));
            table.addCell(new Paragraph(String.valueOf(product.getPrice())));
            table.addCell(new Paragraph(String.valueOf(product.getDiscountedPrice())));
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