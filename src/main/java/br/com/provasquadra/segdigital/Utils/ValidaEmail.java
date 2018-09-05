package br.com.provasquadra.segdigital.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaEmail {
	public static boolean isEmailValido(String email) {
		if (email != null) {
			Pattern p = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
			Matcher m = p.matcher(email);
			return m.find();
		}
		return false;
	}

}
