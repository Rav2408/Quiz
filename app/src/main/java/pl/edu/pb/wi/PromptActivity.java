package pl.edu.pb.wi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PromptActivity<KEY_EXTRA_ANSWER_SHOWN> extends AppCompatActivity {
    public static final String KEY_EXTRA_ANSWER_SHOWN="pb.edu.pl.wi.quiz.answerShown";
    private boolean correctAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);

        correctAnswer = getIntent().getBooleanExtra(MainActivity.KEY_EXTRA_ANSWER,true);

        Button showHintButton = findViewById(R.id.show_hint_button);
        Button returnButton = findViewById(R.id.return_from_hint);
        TextView hintTextView = findViewById(R.id.hint_answer_text_view);

        showHintButton.setOnClickListener(view -> {
            hintTextView.setText(correctAnswer ? R.string.button_true : R.string.button_false);
            setAnswerShownResult(true);
        });

        returnButton.setOnClickListener(view -> {
            finish();
        });
    }

    private void setAnswerShownResult(boolean answerWasShown) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_EXTRA_ANSWER_SHOWN, answerWasShown);
        setResult(RESULT_OK,resultIntent);
    }

}