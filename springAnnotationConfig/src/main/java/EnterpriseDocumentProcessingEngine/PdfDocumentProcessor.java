package EnterpriseDocumentProcessingEngine;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PdfDocumentProcessor implements DocumentProcessor{
	@Override
	public void processDocument(String documentName)
	{
		System.out.println("Document: "+documentName);
	}
}
