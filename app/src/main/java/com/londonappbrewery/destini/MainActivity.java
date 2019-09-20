package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    private TextView storyText;
    private Button answerTopBtn;
    private Button answerBottomBtn;
    private int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("StoryIndex");
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        storyText = findViewById(R.id.storyTextView);
        answerTopBtn = findViewById(R.id.buttonTop);
        answerBottomBtn = findViewById(R.id.buttonBottom);

        setLayoutText(mStoryIndex);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        answerTopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex == 1 || mStoryIndex == 2) {
                    setLayoutText(3);
                    mStoryIndex = 3;
                } else if (mStoryIndex == 3) {
                    setLayoutText(6);
                    removeAnswersAtEnd();
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        answerBottomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex == 1) {
                    setLayoutText(2);
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2) {
                    setLayoutText(4);
                    removeAnswersAtEnd();
                } else if (mStoryIndex == 3) {
                    setLayoutText(5);
                    removeAnswersAtEnd();
                }
            }
        });
    }

    private void setLayoutText(int storyIndex) {
        switch (storyIndex) {
            case 1:
                storyText.setText(getText(R.string.T1_Story));
                answerTopBtn.setText(getText(R.string.T1_Ans1));
                answerBottomBtn.setText(getText(R.string.T1_Ans2));
                break;
            case 2:
                storyText.setText(getText(R.string.T2_Story));
                answerTopBtn.setText(getText(R.string.T2_Ans1));
                answerBottomBtn.setText(getText(R.string.T2_Ans2));
                break;
            case 3:
                storyText.setText(getText(R.string.T3_Story));
                answerTopBtn.setText(getText(R.string.T3_Ans1));
                answerBottomBtn.setText(getText(R.string.T3_Ans2));
                break;
            case 4:
                storyText.setText(getText(R.string.T4_End));
                break;
            case 5:
                storyText.setText(getText(R.string.T5_End));
                break;
            case 6:
                storyText.setText(getText(R.string.T6_End));
                break;
        }
    }

    private void removeAnswersAtEnd() {
            answerTopBtn.setVisibility(View.GONE);
            answerBottomBtn.setVisibility(View.GONE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryIndex",mStoryIndex);
    }
}
