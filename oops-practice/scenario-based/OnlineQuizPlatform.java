import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InvalidQuizSubmissionException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid quiz submission: Answer count mismatch.";
    }
}

class User {
    protected final String userId;
    private String name;
    private String[] userAnswers;

    public User(String userId, String name, int totalQuestions) {
        this.userId = userId;
        this.name = name;
        this.userAnswers = new String[totalQuestions];
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String[] getUserAnswers() {
        return userAnswers;
    }
}


public class OnlineQuizPlatform {

    private static final Scanner scan = new Scanner(System.in);

    private static final String[] quizQuestions = {"Which planet is closest to the sun?","What gas do humans exhale that plants absorb?","How many degrees are in a circle?","Which continent is the biggest?","How many colors are there in a rainbow?","Calculate: 54 + 71 * 4 / 2 - 7","Who painted the Mona Lisa?","Largest country by land area?","Which planet is known as the Red Planet?","Largest ocean in the world?"};
    private static final String[] correctAnswers = {"Mercury", "Carbon Dioxide", "360", "Asia", "7","189", "Vincent van Gogh", "Russia", "Mars", "Pacific"};

    private static final List<Integer> allScores = new ArrayList<>();

    // Display quiz and collect answers
    public static void conductQuiz(User user) {
        String[] answers = user.getUserAnswers();
        System.out.println("\nQuiz Started:");

        for (int i = 0; i < quizQuestions.length; i++) {
            System.out.println((i + 1) + ". " + quizQuestions[i]);
            System.out.print("Your answer: ");
            answers[i] = scan.nextLine().trim();
        }
    }

    // Method to check answer
    private static boolean checkAnswer(int index, String answer) {
        return correctAnswers[index].equalsIgnoreCase(answer);
    }

    // Method to calculate score
    public static int calculateScore(String[] userAnswers)
            throws InvalidQuizSubmissionException {

        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException();
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (checkAnswer(i, userAnswers[i])) {
                score++;
            }
        }
        allScores.add(score);
        return score;
    }

    //Method to calculate Percentage
    public static double calculatePercentage(int score) {
        return (score * 100.0) / correctAnswers.length;
    }

    //Method to calculate grade
    public static String getGrade(int score) {
        if (score >= 8) return "A";
        if (score >= 6) return "B";
        if (score >= 4) return "C";
        return "Fail";
    }

    //Method to display result
    public static void displayResult(User user) throws InvalidQuizSubmissionException {

        int score = calculateScore(user.getUserAnswers());

        System.out.println("\nResult:");
        System.out.println("User ID: " + user.getUserId());
        System.out.println("Name: " + user.getName());
        System.out.println("Score: " + score + "/" + correctAnswers.length);
        System.out.printf("Percentage: %.1f%%%n", calculatePercentage(score));
        System.out.println("Grade: " + getGrade(score));
    }

    // Display all users' scores
    public static void displayAllScores() {
        System.out.println("\nAll User Scores:");
        for (int i = 0; i < allScores.size(); i++) {
            System.out.println("User " + (i + 1) + ": " + allScores.get(i));
        }
    }

    public static void main(String[] args) {
        try {
            User user1 = new User("USR101", "Ava", quizQuestions.length);

            conductQuiz(user1);
            displayResult(user1);

            displayAllScores();

        } catch (InvalidQuizSubmissionException e) {
            System.out.println(e.getMessage());
        }
    }
}
