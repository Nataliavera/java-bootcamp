package clase16.service.impl;

import clase16.parser.IParser;
import clase16.parser.impl.XLSXFileParser;
import clase16.service.FileService;
import clase16.types.XLSX;

public class XLSFServiceParser implements FileService {
	
	private IParser<XLSX> parser;
	
	public XLSFServiceParser(String file) {
		this.parser = new XLSXFileParser(file);
	}

	@Override
	public boolean validar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

}
