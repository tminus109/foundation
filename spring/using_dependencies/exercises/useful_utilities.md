Useful Utilities

Create a controller with 4 endpoints where the user can use the useful utilities.

First steps:

Have a main page at /useful.
This should contain links to all available utilities detailed below.
Use this UtilityService as a dependency for your controller.

@Service
public class UtilityService {
private List<String> colors;
private Random random;

public UtilityService() {
colors = new ArrayList<>();
colors.add("red");
colors.add("blue");
colors.add("lime");
colors.add("orange");
colors.add("magenta");
random = new Random();
}

public String randomColor() {
return colors.get(random.nextInt(colors.size()));
}

public String caesar(String text, int number) {
if (number < 0) {
number = 26 + number;
}
String result = "";
for (int i = 0; i < text.length(); i++) {
int offset = Character.isUpperCase(text.charAt(i)) ? 'A' : 'a';
result += (char) (((int) text.charAt(i) + number - offset) % 26 + offset);
}
return result;
}
}

Colored Background:

Have an endpoint /useful/colored.
It should display an empty page with a random color background.
Have a link at the main page to reach this endpoint.

Email validator:

Have an endpoint at /useful/email with a queryparam.
Have a link at the main page to an example: /useful/email?email=is@this.valid
Create a validateEmail() method in the UtilityService.
Check if the string contains a '@' and a '.'.
Display the following to the user:
- is@this.valid is a valid email address in green
- not_valid_email.com is not a valid email address in red

Caesar encoder/decoder:

Caesar coding is just shifting every character in the text with a specific number of amount
in the alphabet, coded example with 1 is fybnqmf.
Have two endpoints (one for encoding and one for decoding) with a text and number query param.
Have a link at the main page for both.
For encoding, use the number value, for decoding use the -number value,
when calling the caesar() method.
As a rule of usage: you cannot give negative value for the number query param.
