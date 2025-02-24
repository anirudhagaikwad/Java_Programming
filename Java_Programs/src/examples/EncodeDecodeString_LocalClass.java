package examples;

public class EncodeDecodeString_LocalClass {
	    public void encodeDecodeString(String input) {
	        // Local Class for Encoding and Decoding
	        class EncoderDecoder {
	            private String encode(String str) {
	                StringBuilder sb = new StringBuilder();
	                for (char ch : str.toCharArray()) {
	                    sb.append((char) (ch + 3)); // Shift characters by 3
	                }
	                return sb.toString();
	            }

	            private String decode(String str) {
	                StringBuilder sb = new StringBuilder();
	                for (char ch : str.toCharArray()) {
	                    sb.append((char) (ch - 3)); // Shift characters back
	                }
	                return sb.toString();
	            }
	        }

	        EncoderDecoder ed = new EncoderDecoder();
	        String encoded = ed.encode(input);
	        String decoded = ed.decode(encoded);

	        System.out.println("Original: " + input);
	        System.out.println("Encoded: " + encoded);
	        System.out.println("Decoded: " + decoded);
	    }

	    public static void main(String[] args) {
	        new EncodeDecodeString_LocalClass().encodeDecodeString("Hello123");
	    }
	}

