package com.example.selfassessment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

//Main Activity Class
public class MainActivity extends AppCompatActivity {

    //Variables
    int questionCounter = 0;
    boolean safe = true;

    //Functions
    TextView progressTracker, question;
    Button yes, no;

    //ArrayList for Questions and Responses
    ArrayList<QuestionsAndResponses> questionsAndResponsesArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find by id
        this.progressTracker = findViewById(R.id.progressTracker);
        this.question = findViewById(R.id.question);
        this.yes = findViewById(R.id.yes);
        this.no = findViewById(R.id.no);

        //Questions and Answers
        questionsAndResponsesArrayList.add(new QuestionsAndResponses("Have You Tested Positive For Covid-19?","Yes","No","No"));
        questionsAndResponsesArrayList.add(new QuestionsAndResponses("Have You Come Into Contact With Anyone That Has Tested Positive For Covid-19?","Yes","No","No"));
        questionsAndResponsesArrayList.add(new QuestionsAndResponses("Have You Travelled Anywhere Outside Of Canada In The Past 14 Days?","Yes","No","No"));
        questionsAndResponsesArrayList.add(new QuestionsAndResponses("Have You Come Into Contact With Any Person That Has Flu-Like Symptoms In The Past 14 Days?","Yes","No","No"));
        questionsAndResponsesArrayList.add(new QuestionsAndResponses("Do You Have A Cough?","Yes","No","No"));
        questionsAndResponsesArrayList.add(new QuestionsAndResponses("Do You Have A Fever?","Yes","No","No"));
        questionsAndResponsesArrayList.add(new QuestionsAndResponses("Do You Have Shortness Off Breath?","Yes","No","No"));
        questionsAndResponsesArrayList.add(new QuestionsAndResponses("Do You Have A Sore Throat?","Yes","No","No"));
        questionsAndResponsesArrayList.add(new QuestionsAndResponses("Do You Have A Runny Nose?","Yes","No","No"));
        questionsAndResponsesArrayList.add(new QuestionsAndResponses("Do You Feel Unwell?","Yes","No","No"));

        questions(questionCounter);
    }

    //Display questions
    public void questions(int questionNumber){

        //Update the progress tracker
        QuestionsAndResponses q = questionsAndResponsesArrayList.get(questionNumber);
        progressTracker.setText("Question "+(questionNumber+1)+"/10");

        //Get & Set
        question.setText((questionNumber+1)+". "+q.getQuestion());
        yes.setText(q.getYes());
        no.setText(q.getNo());

        //Determine whether the user is safe based off their response
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //If the user selects no (double check if its the safe option)
                if (no.getText().equals(q.getSafe())){
                    safe = true;

                    //If Self Assessment is not complete
                    if (questionCounter<(questionsAndResponsesArrayList.size()-1)){
                        questionCounter++;
                        questions(questionCounter);
                    }

                    //If Self Assessment is complete
                    else{
                        //If the user is not safe, advise them (ERIC PUT UR STUFF IN HERE)
                        if (safe=false){

                        }
                        //If the user is safe, remind them to follow safety precautions (ERIC PUT STUFF IN HERE)
                        else{

                        }
                    }
                }

                //If user selects yes, they are not safe
                else{
                    safe = false;
                }

            }
        });
    }

}