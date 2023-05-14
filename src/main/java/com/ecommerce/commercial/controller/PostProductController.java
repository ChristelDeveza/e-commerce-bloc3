package com.ecommerce.commercial.controller;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.ecommerce.commercial.model.PostProduct;
import com.ecommerce.commercial.service.PostProductService;

@RestController
@CrossOrigin
@RequestMapping(value="/create")
public class PostProductController {

  @Autowired
  private PostProductService postProductService;
  
// @PostMapping
// public void createProduct(@RequestBody PostProduct postProduct) {
//   postProductService.createProduct(postProduct);
// }

@PostMapping
public RedirectView createProduct(@RequestPart PostProduct postProduct, @RequestParam("image") MultipartFile multipartFile) throws IOException {
      String photo = StringUtils.cleanPath(multipartFile.getOriginalFilename());
      postProduct.setImage(photo);
      PostProduct savedPostProduct = postProductService.createProduct(postProduct);
  String uploadDir = "commercial/src/main/resources/static/photo/" + savedPostProduct.getId();
  FileUploadUtil.saveFile(uploadDir, photo, multipartFile);
  return new RedirectView("/products", true);
}

public class FileUploadUtil {
  public static void saveFile(String uploadDir, String photo,
            MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
         
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
         
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(photo);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + photo, ioe);
        }      
    }
}

}
