package com.semanticsquare.basics.parser;


public class APIResponseParser {
    
     /**
	 * Parses the input text and returns a Book instance containing
	 * the parsed data. 
	 * @param response text to be parsed
	 * @return Book instance containing parsed data
	 */
     public static Book parse(String response) {
        Book book = new Book();

        //get Title
		String title = parse(response, "<title>", "</title>");
	    book.setTitle(title);

	    //getAuthor's Name
		String author = parse(response, "<author>", "</author>");
		String authorsName = parse(author, "<name>", "</name>");
	    book.setAuthor(authorsName);

	    //get Publication year
		 String publicationYear = parse(response, "<original_publication_year type=\"integer\">",
				 		"</original_publication_year>");
		 book.setPublicationYear(Integer.parseInt(publicationYear));

		 //get AverageRating
		 String averageRating = parse(response, "<average_rating>", "</average_rating>");
		 book.setAverageRating(Double.parseDouble(averageRating));

		 //get RatingsCount
		 String ratingsCount = parse(response, "<ratings_count type=\"integer\">", "</ratings_count>");
		 book.setRatingsCount(Integer.parseInt(ratingsCount.replaceAll(",", "")));

		 //get ImageUrl
		 String imageUrl = parse(response, "<best_book type=\"Book\">", "</best_book>");
		 imageUrl = parse(imageUrl, "<image_url>","</image_url>");
		 book.setImageUrl(imageUrl);


	    
		
		// Your code
		return book;
     }

	private static String parse(String response, String startRule, String endRule) {

     	int indexOfStartRule = response.indexOf(startRule);
     	String s = response.substring(indexOfStartRule);
     	int indexOfFirstCharOfParsedPhrase = s.indexOf('>')+1;
     	s = s.substring(indexOfFirstCharOfParsedPhrase);
     	int indexOfEndRule = s.indexOf(endRule);
     	s = s.substring(0, indexOfEndRule);

     	return s;
	}

	// write overloaded parse method with the 3 parameters response, startRule, endRule
     
     public static void main(String[] args) {
		String response = "<work>" + 
	                            "<id type=\"integer\">2361393</id>" +
	                            "<books_count type=\"integer\">813</books_count>" +
	                            "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
	                            "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
	                            "<original_publication_year type=\"integer\">1854</original_publication_year>" +
								"<original_publication_month type=\"integer\" nil=\"true\"/>" +
								"<original_publication_day type=\"integer\" nil=\"true\"/>" +
								"<average_rating>3.79</average_rating>" +
								"<best_book type=\"Book\">" +
									"<id type=\"integer\">16902</id>" +
									"<title>Walden</title>" + 
									"<author>" +
										"<id type=\"integer\">10264</id>" + 
										"<name>Henry David Thoreau</name>" + 
									"</author>" +
									"<image_url>" + 
										"http://images.gr-assets.com/books/1465675526m/16902.jpg" +
									"</image_url>" +
									"<small_image_url>" + 
										"http://images.gr-assets.com/books/1465675526s/16902.jpg" +
									"</small_image_url>" +
								"</best_book>" +
							"</work>";
		
		APIResponseParser.parse(response);
	}
}