package vn.edu.vinaenter.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class SlugUtil {
	public static  String makeSlug(String title) {
		String slug = Normalizer.normalize(title, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");	
		slug = pattern.matcher(slug).replaceAll("");
		slug = slug.toLowerCase();
		slug = slug.replaceAll("đ", "d");
		slug = slug.replaceAll("[^0-9a-z-\\s]", "");
		slug = slug.replaceAll(("-+"), "(-)");
		slug = slug.replaceAll("-+", "");
		slug = slug.replaceAll("-$", "");
		slug = slug.replaceAll("[\\s]","-");
		slug = slug.replaceAll("[\\s]","-");
		
		return slug;
	}
}
