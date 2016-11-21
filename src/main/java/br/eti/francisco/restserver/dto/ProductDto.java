package br.eti.francisco.restserver.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import br.eti.francisco.restserver.entity.Product;

@XmlRootElement
public class ProductDto {

	private Integer id;
	
	private String name;
	
	private BigDecimal price;
	
	private String characteristics;

	public static ProductDto fromPlayer(Product product){
		ProductDto productDto = new ProductDto();
		productDto.id = product.getId();
		productDto.name = product.getName();
		productDto.price = product.getPrice();
		productDto.characteristics = product.getCharacteristics();
		return productDto;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
}
