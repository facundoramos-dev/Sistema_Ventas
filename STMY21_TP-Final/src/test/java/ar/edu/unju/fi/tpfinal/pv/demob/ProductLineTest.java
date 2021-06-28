package ar.edu.unju.fi.tpfinal.pv.demob;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.repository.IProductLineRepository;

@SpringBootTest
public class ProductLineTest {

	@Autowired
	IProductLineRepository productLineRepository;
	
	@Test
	void testGuardarProductLine() {
		
		ProductLine productLine = new ProductLine();
		
		productLine.setProductLine("xp-pen");
		productLine.setTextDescription("no entiendo como esto paso");
		productLine.setHtmlDescription("igual que un hechizo que no quebrara");
		productLine.setImage(null);
		
		productLineRepository.save(productLine);
		
		assertEquals(10,productLine.getTextDescription());
	}
}
