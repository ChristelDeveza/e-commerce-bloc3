package com.ecommerce.commercial.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.commercial.model.PutDiscount;
import com.ecommerce.commercial.model.UpdateProduct;
import com.ecommerce.commercial.repository.UpdateProductRepository;
import com.ecommerce.commercial.service.UpdateProductService;

@Service
public class UpdateProductServiceImpl implements UpdateProductService{
  @Autowired
  private UpdateProductRepository updateProductRepository;

  @Override
  public void updateProduct(Long id, UpdateProduct updateProduct) {
    // Optional<UpdateProduct> existingProduct = updateProductRepository.findById(id);
    // if (existingProduct.isPresent()) {
    //   UpdateProduct updatedProduct = existingProduct.get();
    //   // ...

    //   // Obtenez le discount correspondant à l'ID
    //   if (updateProduct.getPutDiscount() != null && !updateProduct.getPutDiscount().isEmpty()) {
    //     Long discountId = updateProduct.getPutDiscount().get(0).getId(); // Vous pouvez adapter cette logique selon vos besoins
    //     PutDiscount putDiscount = putDiscountService.getPutDiscountById(discountId);
    //     if (putDiscount != null && putDiscount.getPercentage() != null) {
    //       Long percentage = putDiscount.getPercentage();
    //       Long price = updatedProduct.getPrice();
    //       Long discountAmount = (price * percentage) / 100;
    //       updatedProduct.setDiscountedPrice(price - discountAmount);
    //     }
    //   }
    Optional<UpdateProduct> existingProduct = updateProductRepository.findById(id);
    if(existingProduct.isPresent()) {
      UpdateProduct updatedProduct = existingProduct.get();
      if(updateProduct.getName() != null){
        updatedProduct.setName(updateProduct.getName());
      }
      if(updateProduct.getPrice() != null) {
        updatedProduct.setPrice(updateProduct.getPrice());
      }

      if(updateProduct.getDescription() != null) {
        updatedProduct.setDescription(updateProduct.getDescription());
      }

      if(updateProduct.getCategoryId() != null) {
        updatedProduct.setCategoryId(updateProduct.getCategoryId());
      }

      // For loop iteration to access to getPercentage() in PutDiscount
      // if (updateProduct.getPutDiscount() != null) {
      //   for (PutDiscount putDiscount : updateProduct.getPutDiscount()) {
      //     if (putDiscount.getPercentage() != null) {
      //       Long percentage = putDiscount.getPercentage();
      //       Long price = updateProduct.getPrice();
      //       Long discountAmount = (price * percentage) / 100;
      //       updatedProduct.setDiscountedPrice(price - discountAmount);
           
      //     }
      //   }
      // }


    //     Long newDiscountedPrice = null;
    //   if (updateProduct.getPutDiscount() != null) {
    //     for (PutDiscount putDiscount : updateProduct.getPutDiscount()) {
    //         if (putDiscount.getPercentage() != null) {
    //             Long percentage = putDiscount.getPercentage();
    //             Long price = updateProduct.getPrice();
    //             Long discountAmount = (price * percentage) / 100;
    //             Long discountedPrice = price - discountAmount;
    //             updatedProduct.setDiscountedPrice(discountedPrice);
    //         }
    //     }
    // }
    
    // // Mettre à jour le discountedPrice si le prix a été modifié
    // if (updateProduct.getPrice() != null) {
    //     Long newPrice = updateProduct.getPrice();
    //     Long oldPrice = updatedProduct.getPrice();
    //     Long oldDiscountedPrice = updatedProduct.getDiscountedPrice();
    
    //     if (oldPrice != null && oldDiscountedPrice != null) {
    //         // Vérifier si le nouveau prix est différent de l'ancien prix
    //         if (!oldPrice.equals(newPrice)) {
    //             // Calculer le montant de la remise en fonction du pourcentage actuel
    //             Long percentage = null;
    //             for (PutDiscount putDiscount : updateProduct.getPutDiscount()) {
    //                 if (putDiscount.getPercentage() != null) {
    //                     percentage = putDiscount.getPercentage();
    //                     break;
    //                 }
    //             }
    //             if (percentage != null) {
    //                 Long newDiscountAmount = (newPrice * percentage) / 100;
    //                 newDiscountedPrice = newPrice - newDiscountAmount;
    
    //                 // Mettre à jour le discountedPrice seulement si le nouveau prix entraîne une modification du montant remisé
    //                 if (!oldDiscountedPrice.equals(newDiscountedPrice)) {
    //                     updatedProduct.setDiscountedPrice(newDiscountedPrice);

    //                     // updateProductRepository.save(updatedProduct);
    //                 }
    //             }
    //         }
    //     }
    // }
    
    // Long newDiscountedPrice = null;

    // if (updateProduct.getPutDiscount() != null) {
    //     for (PutDiscount putDiscount : updateProduct.getPutDiscount()) {
    //         if (putDiscount.getPercentage() != null) {
    //             Long percentage = putDiscount.getPercentage();
    //             Long price = updateProduct.getPrice();
    //             Long discountAmount = (price * percentage) / 100;
    //             newDiscountedPrice = price - discountAmount;
    //             updatedProduct.setDiscountedPrice(newDiscountedPrice);
    //         }
    //     }
    // }
    
    // // Mettre à jour le discountedPrice si le prix a été modifié
    // if (updateProduct.getPrice() != null) {
    //     Long newPrice = updateProduct.getPrice();
    //     Long oldPrice = updatedProduct.getPrice();
    //     Long oldDiscountedPrice = updatedProduct.getDiscountedPrice();
    
    //     if (oldPrice != null) {
    //         // Vérifier si le nouveau prix est différent de l'ancien prix
    //         if (!oldPrice.equals(newPrice)) {
    //             if (newDiscountedPrice != null) {
    //                 // Mettre à jour le discountedPrice seulement si le nouveau prix entraîne une modification du montant remisé
    //                 if (!oldDiscountedPrice.equals(newDiscountedPrice)) {
    //                     updatedProduct.setDiscountedPrice(newDiscountedPrice);
    //                 }
    //             } else {
    //                 // Calculer le montant de remise basé sur le pourcentage actuel
    //                 Long percentage = null;
    //                 for (PutDiscount putDiscount : updateProduct.getPutDiscount()) {
    //                     if (putDiscount.getPercentage() != null) {
    //                         percentage = putDiscount.getPercentage();
    //                         break;
    //                     }
    //                 }
    //                 if (percentage != null) {
    //                     Long discountAmount = (newPrice * percentage) / 100;
    //                     newDiscountedPrice = newPrice - discountAmount;
    //                     // Mettre à jour le discountedPrice seulement si le nouveau prix entraîne une modification du montant remisé
    //                     if (!oldDiscountedPrice.equals(newDiscountedPrice)) {
    //                         updatedProduct.setDiscountedPrice(newDiscountedPrice);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    // }

    // // Enregistrer les modifications dans la base de données
    // updateProductRepository.save(updatedProduct);
    
          //With period constraint // Ne fonctionne pas 
      if (updateProduct.getPutDiscount() != null) {
        LocalDate currentDate = LocalDate.now();
        for (PutDiscount putDiscount : updateProduct.getPutDiscount()) {
          LocalDate startDate = putDiscount.getStartDate();
          LocalDate endDate = putDiscount.getEndDate();
          if (startDate != null && endDate != null && currentDate.compareTo(startDate) >=0  && currentDate.compareTo(endDate) <=0) {
            if (putDiscount.getPercentage() != null) {
            Long percentage = putDiscount.getPercentage();
            Long price = updateProduct.getPrice();
            Long discountAmount = (price * percentage) / 100;
            updatedProduct.setDiscountedPrice(price - discountAmount);
            break; 
            }
          }
        }
        }


      // updateProductRepository.save(updatedProduct);

//       Long newDiscountedPrice = null;

// // Mettre à jour le discountedPrice en fonction des remises appliquées
// if (updateProduct.getPutDiscount() != null) {
//     for (PutDiscount putDiscount : updateProduct.getPutDiscount()) {
//         if (putDiscount.getPercentage() != null) {
//             Long percentage = putDiscount.getPercentage();
//             Long price = updateProduct.getPrice();
//             Long discountAmount = (price * percentage) / 100;
//             newDiscountedPrice = price - discountAmount;
//             break; // Nous mettons à jour le discountedPrice en utilisant le premier pourcentage trouvé
//         }
//     }
// }

// // Mettre à jour le prix
// if (updateProduct.getPrice() != null) {
//     Long newPrice = updateProduct.getPrice();
//     Long oldPrice = updatedProduct.getPrice();

//     if (oldPrice != null && !oldPrice.equals(newPrice)) {
//         // Vérifier si le nouveau prix est différent de l'ancien prix

//         // Mettre à jour le prix
//         updatedProduct.setPrice(newPrice);

//         // Mettre à jour le discountedPrice seulement si le nouveau prix entraîne une modification du montant remisé
//         if (newDiscountedPrice != null && !newDiscountedPrice.equals(updatedProduct.getDiscountedPrice())) {
//             updatedProduct.setDiscountedPrice(newDiscountedPrice);
//         } else {
//             // Calculer le montant de remise basé sur le pourcentage actuel
//             Long percentage = null;
//             for (PutDiscount putDiscount : updateProduct.getPutDiscount()) {
//                 if (putDiscount.getPercentage() != null) {
//                     percentage = putDiscount.getPercentage();
//                     break;
//                 }
//             }
//             if (percentage != null) {
//                 Long discountAmount = (newPrice * percentage) / 100;
//                 newDiscountedPrice = newPrice - discountAmount;
//                 // Mettre à jour le discountedPrice seulement si le nouveau prix entraîne une modification du montant remisé
//                 if (!newDiscountedPrice.equals(updatedProduct.getDiscountedPrice())) {
//                     updatedProduct.setDiscountedPrice(newDiscountedPrice);
//                 }
//             }
//         }
//     }
    // }

// Enregistrer les modifications dans la base de données
updateProductRepository.save(updatedProduct);

    }
  }
}