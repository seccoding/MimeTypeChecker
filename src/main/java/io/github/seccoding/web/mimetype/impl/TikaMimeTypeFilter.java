package io.github.seccoding.web.mimetype.impl;

import java.io.File;
import java.io.IOException;

import org.apache.tika.Tika;

import io.github.seccoding.web.mimetype.abst.ExtensionFilter;

public class TikaMimeTypeFilter extends ExtensionFilter {

	@Override
	protected String getMimeType(File currentFile) {
		String mimeType = null;
	    try {
	    	Tika tika = new Tika();
			mimeType = tika.detect(currentFile);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		return mimeType;
	}

	@Override
	protected boolean isEquals(String mimeTypeOfFile, String extension) {
		if ( mimeTypeOfFile.equalsIgnoreCase( extension.toUpperCase() ) ) {
			return true;
		}
		return false;
	}

}
