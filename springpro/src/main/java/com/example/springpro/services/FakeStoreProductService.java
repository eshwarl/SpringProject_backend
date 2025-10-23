package com.example.springpro.services;

import com.example.springpro.dtos.FakeStoreProductDto;
import com.example.springpro.exceptions.ProductNotFound;
import com.example.springpro.models.Category;
import com.example.springpro.models.product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductServices {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private product covertFakeProducDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        product product = new product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());
        return product;
    }

    @Override
    public product getProductById(Long productId) throws ProductNotFound {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        if (fakeStoreProductDto == null) {
            throw new ProductNotFound("Product with id:" + productId + " doesn't exist");
        }

        return covertFakeProducDtoToProduct(fakeStoreProductDto);
    }


    @Override
    public List<product> getAllProducts(){
       FakeStoreProductDto[] fakeStoreProductDtos=restTemplate.getForObject(
                "https://fakestoreapi.com/products/",FakeStoreProductDto[].class

        );
        List<product> products=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
            products.add(covertFakeProducDtoToProduct(fakeStoreProductDto));
        }
        return products;

    }
}
