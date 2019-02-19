package io.github.seccoding.web.mimetype;

import io.github.seccoding.web.mimetype.ExtFilter;
import io.github.seccoding.web.mimetype.ExtensionFilter;
import io.github.seccoding.web.mimetype.ExtensionFilterFactory;
import io.github.seccoding.web.mimetype.MimeType;

public class ExtensionFilterTest {

	public static void main(String[] args) {
		
		ExtensionFilter filter = ExtensionFilterFactory.getFilter(ExtFilter.COMPARE_EXTENSION);
		boolean isPdfFile = filter.doFilter("C:\\Users\\mcjan\\Documents\\장민창님 급여명세서\\2018 급여명세서\\1월 급여명세서.pdf", "pdf");
		System.out.println(isPdfFile);
		
		filter = ExtensionFilterFactory.getFilter(ExtFilter.JMIME_MAGIC);
		isPdfFile = filter.doFilter("C:\\Users\\mcjan\\Documents\\장민창님 급여명세서\\2018 급여명세서\\1월 급여명세서.pdf", MimeType.PDF);
		System.out.println(isPdfFile);
		
		filter = ExtensionFilterFactory.getFilter(ExtFilter.APACHE_TIKA);
		isPdfFile = filter.doFilter("C:\\Users\\mcjan\\Documents\\장민창님 급여명세서\\2018 급여명세서\\1월 급여명세서.pdf", MimeType.PDF);
		System.out.println(isPdfFile);
	}
	
}
