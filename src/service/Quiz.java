package service;

import model.Question;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question(
                "Which programming language is used for Android app development?",
                List.of("Python", "Java", "C++", "Ruby"), 1
        ));
        questions.add(new Question(
                "What does OOP stand for?",
                List.of("Object Oriented Programming", "Only Old People", "Open Office Project", "Object Open Protocol"), 0
        ));
        questions.add(new Question(
                "Which company developed Java?",
                List.of("Microsoft", "Sun Microsystems", "Google", "IBM"), 1
        ));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Welcome to the Quiz =====");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestionText());
            List<String> opts = q.getOptions();
            for (int j = 0; j < opts.size(); j++) {
                System.out.println((j + 1) + ". " + opts.get(j));
            }
            System.out.print("Your answer: ");
            int answer = scanner.nextInt() - 1;

            if (answer == q.getCorrectOptionIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer is: " + opts.get(q.getCorrectOptionIndex()));
            }
        }

        System.out.println("\n===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + questions.size());
        scanner.close();
    }
}
