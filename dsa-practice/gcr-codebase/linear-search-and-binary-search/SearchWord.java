//Problem statement:
//You are given an array of sentences (strings). 
//Write a program that performs Linear Search to find the first sentence containing a specific word. 
//If the word is found, return the sentence. If no sentence contains the word, return "Not Found".

import java.util.Scanner;

public class SearchWord {

    public static String searchString(String[] sentences, String word){
        for(String sentence: sentences){
            if(sentence.toLowerCase().contains(word.toLowerCase())){
                return sentence;
            }
        }
        return "Not Found";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of sentences: ");
        int len = scanner.nextInt();
        scanner.nextLine();
        String []sentences = new String[len];
        for(int i=0 ; i<len; i++){
            System.out.print("Enter sentence "+(i+1)+": ");
            sentences[i]=scanner.nextLine();
        }
        System.out.print("Enter the word to search: ");
        String word = scanner.next();
        String searchWord = searchString(sentences, word);
        System.out.println(searchWord);
    }
}
