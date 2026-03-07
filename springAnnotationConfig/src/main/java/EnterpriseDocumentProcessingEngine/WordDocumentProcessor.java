package EnterpriseDocumentProcessingEngine;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class WordDocumentProcessor implements DocumentProcessor{
@Override
public void processDocument(String documentName)
{
	System.out.println("Document: "+documentName);
}
}
