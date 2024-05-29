package exercise.controller;

import exercise.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

import exercise.repository.ProductRepository;
import exercise.dto.ProductDTO;
import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.ProductMapper;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> index() {
        List<Product> products = productRepository.findAll();

        List<ProductDTO> productsDTO = products.stream()
                .map(productMapper::map)
                .toList();

        return productsDTO;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO show(@PathVariable long id) {
        Product product = productRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        ProductDTO productDTO = productMapper.map(product);
        return productDTO;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductCreateDTO productCreateDTO) {
        Product product = productMapper.map(productCreateDTO);
        productRepository.save(product);
        ProductDTO productDTO = productMapper.map(product);

        return productDTO;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO update(@RequestBody ProductUpdateDTO productUpdateDTO, @PathVariable long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        productMapper.update(productUpdateDTO, product);
        productRepository.save(product);
        ProductDTO productDTO = productMapper.map(product);

        return productDTO;
    }
    // END
}
