package EnterpriseDocumentProcessingEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DocumentEngine {
	private DocumentProcessor documentProcessor;
	private XmlDocumentProcessor xmlDocumentProcessor;
	private AuditService auditService;
	@Autowired
	private StorageService storageService;
	public DocumentEngine(DocumentProcessor documentProcessor,@Qualifier("xmlDocumentProcessor") XmlDocumentProcessor xmlDocumentProcessor)
	{
		this.documentProcessor=documentProcessor;
		this.xmlDocumentProcessor=xmlDocumentProcessor;
	}
	public void setService(AuditService auditService)
	{
		this.auditService=auditService;
	}
}
