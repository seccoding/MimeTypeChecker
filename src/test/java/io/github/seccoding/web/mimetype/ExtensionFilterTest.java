package io.github.seccoding.web.mimetype;

import io.github.seccoding.web.mimetype.ExtFilter;
import io.github.seccoding.web.mimetype.MimeType;
import io.github.seccoding.web.mimetype.abst.ExtensionFilter;
import io.github.seccoding.web.mimetype.factory.ExtensionFilterFactory;

public class ExtensionFilterTest {

	public static void main(String[] args) {
		
		ExtensionFilter filter = ExtensionFilterFactory.getFilter(ExtFilter.COMPARE_EXTENSION);
		boolean isPdfFile = filter.doFilter("File.pdf", "pdf");
		System.out.println(isPdfFile);
		
		filter = ExtensionFilterFactory.getFilter(ExtFilter.JMIME_MAGIC);
		isPdfFile = filter.doFilter("File.pdf", MimeType.PDF);
		System.out.println(isPdfFile);
		
		filter = ExtensionFilterFactory.getFilter(ExtFilter.APACHE_TIKA);
		isPdfFile = filter.doFilter("File.pdf", MimeType.PDF);
		System.out.println(isPdfFile);
	}
	
}
