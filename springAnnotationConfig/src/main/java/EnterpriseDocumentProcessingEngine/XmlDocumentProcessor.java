package EnterpriseDocumentProcessingEngine;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class XmlDocumentProcessor implements DocumentProcessor {
@Override
public void processDocument(String documentName)
{
	System.out.println("Document: "+documentName);
}
}
