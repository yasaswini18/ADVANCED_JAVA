package com.productApp.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.productApp.model.Product;

@Repository
public class ProductRepository {
	private List<Product> productList = new ArrayList<>();
	private Long idCounter = 1L;
	
	public List<Product> findAll()
	{
		return productList;
	}
	
	public void save(Product product)
	{
		if(product.getId()==null)
		{
			product.setId(idCounter++);
			productList.add(product);
		}else {
			update(product);
		}
	}
	
	public Optional<Product> findById(Long id)
	{
		return productList.stream()
				          .filter(n->n.getId().equals(id))
				          .findFirst();
	}
	
	public void deleteById(Long id)
	{
		//productList.removeIf(p->p.getId().equals(id));
		Iterator<Product> it = productList.iterator();
		while(it.hasNext())
		{
			if(it.next().getId().equals(id))
			{
				it.remove();
			}
		}
	}
	
	private void update(Product updatedProduct)
	{
		for(int i=0;i<productList.size();i++)
		{
			if(productList.get(i).equals(updatedProduct.getId()))
			{
				productList.set(i, updatedProduct);
				break;
			}
		}
	}
}
