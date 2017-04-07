import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExploreDTAPI1 {
	/*
	 * Java 8 introduces a brand new Date and Time API that fixes many
	 * problems typical of the old  Date and  Calendar  classes.
	 */

	public static void main(String[] args) {
		/*
		 * For example I would like to have
		 * a break for a lunch in two hours an forty-five minutes from now
		 * I should calculate Date and Time of this moment
		 */
		LocalDateTime lunchBreak = LocalDateTime.now().plusHours(2).plusMinutes(45);
		System.out.println("You will have a lunch at: " +
						lunchBreak.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
	}

}
