package cvtrackertask.info.guesword.controller;

import cvtrackertask.info.guesword.domain.ResponseMessage;
import cvtrackertask.info.guesword.domain.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.util.stream.Collectors;

@Controller
public class GuessWordController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GuessWordController.class);

    private Resource fileResource;
    private Set<String> wordSource;
    private Map<String, Integer> resultsMap;
    private Integer wordCount;
    private int scores = 0;

    public GuessWordController() {
        this.wordSource = new TreeSet<>();
        this.resultsMap = new TreeMap<>();
        this.fileResource = new ClassPathResource("wordsource.txt");
    }

    @RequestMapping(path = "/guessWord", method = RequestMethod.GET)
    public String wordDisplay(Model model)
    {
        String guessedWord = this.generateGuessWord();

        LOGGER.info("Generated: {}", guessedWord);

        model.addAttribute("guessedWord", guessedWord);
        model.addAttribute("maskedGuessedWord", this.maskedWord(guessedWord));

        return "GuessWord";
    }


    @PostMapping(path = "/guessWord")
    public ResponseEntity<ResponseMessage> processWordGuess(@RequestParam("guessedWordInput") String guessedWordInput,
                                                            @RequestParam("guessedWord") String guessedWord)
    {
        LOGGER.info("Submitting the Form:{} {}", guessedWordInput,guessedWord);
        ResponseMessage responseMessage = new ResponseMessage();

        if(!this.validInput(guessedWord,guessedWordInput) )
        {
          responseMessage.setMessage("Input Word Length Wrong.");
          responseMessage.setCode("01");
          LOGGER.info("{}",responseMessage.getMessage());

            return new ResponseEntity<>( responseMessage,HttpStatus.BAD_REQUEST);
        }

        this.processResponse(guessedWordInput, guessedWord);

        if(scores == 0)
        {
            responseMessage.setMessage(String.format( "%s %s Correctly.", "Congratulations! You Guessed", guessedWord));
            responseMessage.setCode("00");
        }
        else
        {
            responseMessage.setMessage("Your Guess is Incorrect.");
            responseMessage.setCode("01");
        }

        ResponseEntity<ResponseMessage> responseEntity = new ResponseEntity<ResponseMessage>(HttpStatus.OK);
         return responseEntity;
    }

    private boolean validInput(String wordSource, String input)
    {

        int srcLenggth = wordSource.length();
        int targetLength = input.length();

        if( srcLenggth < targetLength)
        {
            return false;
        }
        return true;
    }
    private void processResponse(String response, String guessedWord){

        int result = response.compareToIgnoreCase(guessedWord);

        if(result == 0 )
        {
            scores = 0;
            LOGGER.info("{}{} are the same", response, guessedWord);
            this.resultsMap.clear();
        }
        else{

            if( result >= 1 || result  <= 3)
            {
                LOGGER.info("Partial Match {}", result);
            }
            else
            {
                LOGGER.info("Compare Ignore Case: {}", result);
            }
            this.resultsMap.put(response,++scores);
        }

    }

    @PostConstruct
    private void fillWordSource(){

      try(BufferedReader fileReader = new BufferedReader( new InputStreamReader( this.fileResource.getInputStream())))
      {
          String currentLine = null;

          while((currentLine = fileReader.readLine()) != null )
          {
              wordSource.addAll( Arrays.stream( currentLine.split("\\s+")).
                                 map((token)->{ return token.replaceAll("\\W+","").toLowerCase();}).
                                 collect(Collectors.toList()));
          }

          this.wordCount = wordSource.size();
          
      } catch (IOException e) {
          e.printStackTrace();
      }finally {

      }
    }

    private String generateGuessWord()
    {
        int wordIndex = (int)Math.floor ((Math.random() * (this.wordCount + 1)));
        String guessedWord = this.wordSource.stream().toList().get(wordIndex);

        return guessedWord;
    }

    private String maskedWord(String guessedWord) {
        StringBuilder guessWordBuilder= new StringBuilder(guessedWord);
        if( guessedWord.length() >= 7 )
        {
            return guessWordBuilder.replace(1,2, "*").replace(3,4, "*").toString();
        }
        return guessWordBuilder.replace(1,2, "*").toString();
    }
}
