import java.util.Vector;
import java.util.concurrent.Callable;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class psFunctions {

	protected Shell shell;
	private Text PasswordText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			psFunctions window = new psFunctions();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 500);
		shell.setText("Password Strength");

		
		Label PasswordLabel = new Label(shell, SWT.NONE);
		PasswordLabel.setBounds(10, 13, 59, 14);
		PasswordLabel.setText("Password:");
		
		Label PSLabel = new Label(shell, SWT.NONE);
		PSLabel.setBounds(10, 44, 118, 19);
		PSLabel.setText("Password Strength:");
		
		final Label PercentLabel = new Label(shell, SWT.NONE);
		PercentLabel.setBounds(134, 44, 59, 14);
		PercentLabel.setText("0%");
		
		Label lblAdditions = new Label(shell, SWT.NONE);
		lblAdditions.setBounds(10, 74, 299, 14);
		lblAdditions.setText("Additions---------------------------------|");
		
		Label lblCount = new Label(shell, SWT.NONE);
		lblCount.setBounds(315, 74, 59, 14);
		lblCount.setText("Count");
		
		Label lblScore = new Label(shell, SWT.NONE);
		lblScore.setBounds(380, 74, 59, 14);
		lblScore.setText("Score");
		
		Label lblNumberOfCharacters = new Label(shell, SWT.NONE);
		lblNumberOfCharacters.setBounds(170, 94, 135, 14);
		lblNumberOfCharacters.setText("Number of Characters:");
		
	    final Label CharNumCountLabel = new Label(shell, SWT.NONE);
		CharNumCountLabel.setBounds(325, 94, 59, 14);
		CharNumCountLabel.setText("0");
		
		final Label CharNumScoreLabel = new Label(shell, SWT.NONE);
		CharNumScoreLabel.setBounds(390, 94, 59, 14);
		CharNumScoreLabel.setText("0");
		
		
		Label lblUppercaseLetters = new Label(shell, SWT.NONE);
		lblUppercaseLetters.setBounds(193, 114, 116, 14);
		lblUppercaseLetters.setText("Uppercase Letters:");
		
		final Label UpperCount = new Label(shell, SWT.NONE);
		UpperCount.setBounds(325, 114, 59, 14);
		UpperCount.setText("0");
		
		final Label UpperScore = new Label(shell, SWT.NONE);
		UpperScore.setBounds(390, 114, 59, 14);
		UpperScore.setText("0");
		
		Label lblLowercaseLetters = new Label(shell, SWT.NONE);
		lblLowercaseLetters.setBounds(193, 134, 116, 14);
		lblLowercaseLetters.setText("Lowercase Letters:");
		
		final Label LowerCount = new Label(shell, SWT.NONE);
		LowerCount.setBounds(325, 134, 59, 14);
		LowerCount.setText("0");
		
		final Label LowerScore = new Label(shell, SWT.NONE);
		LowerScore.setBounds(390, 134, 59, 14);
		LowerScore.setText("0");
		
		Label lblNumbers = new Label(shell, SWT.NONE);
		lblNumbers.setBounds(241, 154, 73, 14);
		lblNumbers.setText("Numbers:");
		
		final Label NumbersCount = new Label(shell, SWT.NONE);
		NumbersCount.setBounds(325, 154, 59, 14);
		NumbersCount.setText("0");
		
		final Label NumbersScore = new Label(shell, SWT.NONE);
		NumbersScore.setBounds(390, 154, 59, 14);
		NumbersScore.setText("0");
		
		Label lblSymbols = new Label(shell, SWT.NONE);
		lblSymbols.setBounds(244, 174, 59, 19);
		lblSymbols.setText("Symbols:");
		
		final Label SymbolsCount = new Label(shell, SWT.NONE);
		SymbolsCount.setBounds(325, 174, 59, 14);
		SymbolsCount.setText("0");
		
		final Label SymbolsScore = new Label(shell, SWT.NONE);
		SymbolsScore.setBounds(390, 174, 59, 14);
		SymbolsScore.setText("0");
		
		Label lblMiddleNumbersOr = new Label(shell, SWT.NONE);
		lblMiddleNumbersOr.setBounds(138, 194, 171, 14);
		lblMiddleNumbersOr.setText("Middle Numbers or Symbols:");
		
		final Label MidCount = new Label(shell, SWT.NONE);
		MidCount.setBounds(325, 194, 59, 14);
		MidCount.setText("0");
		
		final Label MidScore = new Label(shell, SWT.NONE);
		MidScore.setBounds(390, 194, 59, 14);
		MidScore.setText("0");
		
		Label lblRequirements = new Label(shell, SWT.NONE);
		lblRequirements.setBounds(216, 214, 94, 19);
		lblRequirements.setText("Requirements:");
		
		final Label ReqCount = new Label(shell, SWT.NONE);
		ReqCount.setBounds(325, 214, 59, 14);
		ReqCount.setText("0");
		
		final Label ReqScore = new Label(shell, SWT.NONE);
		ReqScore.setBounds(390, 214, 59, 14);
		ReqScore.setText("0");
		
		
		Label lblDeductions = new Label(shell, SWT.NONE);
		lblDeductions.setText("Deductions---------------------------------------------------|");
		lblDeductions.setBounds(10, 234, 429, 14);
		
		Label lblLettersOnly = new Label(shell, SWT.NONE);
		lblLettersOnly.setBounds(226, 254, 83, 19);
		lblLettersOnly.setText("Letters Only:");
		
		final Label LettersOnlyCount = new Label(shell, SWT.NONE);
		LettersOnlyCount.setBounds(325, 254, 59, 14);
		LettersOnlyCount.setText("0");
		
		final Label LettersOnlyScore = new Label(shell, SWT.NONE);
		LettersOnlyScore.setBounds(390, 254, 59, 14);
		LettersOnlyScore.setText("0");
		
		Label lblNumbersOnly = new Label(shell, SWT.NONE);
		lblNumbersOnly.setBounds(213, 274, 94, 19);
		lblNumbersOnly.setText("Numbers Only:");
		
		final Label NumbersOnlyCount = new Label(shell, SWT.NONE);
		NumbersOnlyCount.setBounds(325, 274, 59, 14);
		NumbersOnlyCount.setText("0");
		
		final Label NumbersOnlyScore = new Label(shell, SWT.NONE);
		NumbersOnlyScore.setBounds(390, 274, 59, 14);
		NumbersOnlyScore.setText("0");
		
		Label lblConsecutiveUppercaseLetters = new Label(shell, SWT.NONE);
		lblConsecutiveUppercaseLetters.setBounds(129, 292, 189, 19);
		lblConsecutiveUppercaseLetters.setText("Consecutive Uppercase Letters:");
		
		final Label ConsecutiveUpperCount = new Label(shell, SWT.NONE);
		ConsecutiveUpperCount.setBounds(325, 292, 59, 14);
		ConsecutiveUpperCount.setText("0");
		
		final Label ConsecutiveUpperScore = new Label(shell, SWT.NONE);
		ConsecutiveUpperScore.setBounds(390, 292, 59, 14);
		ConsecutiveUpperScore.setText("0");
		
		Label lblConsecutiveLowecaseLetters = new Label(shell, SWT.NONE);
		lblConsecutiveLowecaseLetters.setBounds(129, 313, 185, 14);
		lblConsecutiveLowecaseLetters.setText("Consecutive Lowercase Letters: ");
		
		final Label ConsecutiveLowerCount = new Label(shell, SWT.NONE);
		ConsecutiveLowerCount.setBounds(325, 313, 59, 14);
		ConsecutiveLowerCount.setText("0");
		
		final Label ConsecutiveLowerScore = new Label(shell, SWT.NONE);
		ConsecutiveLowerScore.setBounds(390, 313, 59, 14);
		ConsecutiveLowerScore.setText("0");
		
		Label lblConsecutiveNumbers = new Label(shell, SWT.NONE);
		lblConsecutiveNumbers.setBounds(173, 333, 135, 14);
		lblConsecutiveNumbers.setText("Consecutive Numbers: ");
		
		final Label ConsecutiveNumCount = new Label(shell, SWT.NONE);
		ConsecutiveNumCount.setBounds(325, 333, 59, 14);
		ConsecutiveNumCount.setText("0");
		
		final Label ConsecutiveNumScore = new Label(shell, SWT.NONE);
		ConsecutiveNumScore.setBounds(390, 333, 59, 14);
		ConsecutiveNumScore.setText("0");
		
		final Label strengthLabel = new Label(shell, SWT.NONE);
		strengthLabel.setBounds(199, 44, 126, 19);
		strengthLabel.setText("Very Weak");

		
		PasswordText = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		PasswordText.addModifyListener(new ModifyListener() {
			@SuppressWarnings("null")
			public void modifyText(ModifyEvent e) {
				String pass = PasswordText.getText();
				String strength;
				int totalScore = 0;
				int req = 0;
				int digit_count = 0;
				int symbol_count = 0;
				int count;
				int score;
				int len;
				
			    /*
			     * Password Additions:
			     */
			    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
				//Check the length of the string (min:8, better > 8, n*4)
				len = count = pass.length();
				score = 4 * count;
				setLabels(count, score, CharNumCountLabel,CharNumScoreLabel);
				totalScore += score;
				
				//Uppercase letters (good-min:1, metter-min:2, (len-n)*2)
				count = countUppercase(pass);
				score = (len-count)*2;
				if(count>0) req += 1;
				setLabels(count, score, UpperCount, UpperScore);
				totalScore += score;
				
				//Lowercase letters (good-min:1, better-min:2, (len-n)*2)
				count = countLowercase(pass);
				score = (len - count) * 2;
				if(count>0) req += 1;
				setLabels(count,score,LowerCount, LowerScore);
				totalScore += score;
				
			    // Digits (good-min:1, better-min:2, n*4)
				digit_count = count = countDigits(pass);
				if(len-count == 0){
					score = 0;
				}else{
					score = count * 4;
				}
				if(count>0) req += 1;
				setLabels(count, score, NumbersCount, NumbersScore);
				totalScore += score;
				
			    // Symbols (good-min:1, better-min:2, n*6)
				symbol_count = count = countSymbols(pass);
				if(len-count == 0){
					score =0;
				}else{
					score = count * 6;
				}
				if(count>0) req += 1;
				setLabels(count, score, SymbolsCount, SymbolsScore);
				totalScore += score;
				
			    // Middle Numbers or Symbols (good-min:1, better-min:2, n*2)
				count = middleDigitsOrSymbols(pass);
				score = count * 2;
				setLabels(count, score, MidCount, MidScore);
				totalScore += score;
				
			    // Add requirements score
				if(len >= 8){
					req+=1;
				}
				score =0;
				if(len >= 8 && req >= 4){
					score += 2 * req;
				}
				setLabels(req, score, ReqCount, ReqScore);
				totalScore += score;
				
				score =0;
				
				/*
		     	* Password Deductions:
		     	*/
				//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
			    // Letters Only [-n]
				if(len - digit_count - symbol_count == len){
					score = -len;
				}
				setLabels(len-digit_count-symbol_count, score, LettersOnlyCount, LettersOnlyScore);
				totalScore += score;
				
				score=0;
				// Digits Only [-n]
				if(len- digit_count == 0){
					score = -len;
				}
				setLabels(digit_count, score, NumbersOnlyCount, NumbersOnlyScore);
				totalScore += score;
				
			    // Consecutive Uppercase Letters [-(n*2)]
				count = consecUppercase(pass);
				score = -2 * count;
				setLabels(count, score, ConsecutiveUpperCount, ConsecutiveUpperScore);
				totalScore += score;
				
			    // Consecutive Lowercase Letters [-(n*2)]
				count = consecLowercase(pass);
				score = -2 * count;
				setLabels(count, score, ConsecutiveLowerCount, ConsecutiveLowerScore);
				totalScore += score;
				
			    // Consecutive Digits [-(n*2)]
				count = consecDigits(pass);
				score = -2 * count;
				setLabels(count, score, ConsecutiveNumCount, ConsecutiveNumScore);
				totalScore += score;
				
				//controls percent
				if(totalScore <= 20){
					strength = "Very Weak";
				}else if(totalScore <= 40){
					strength = "Weak";
				}else if(totalScore <= 60){
					strength = "Good";
				}else if(totalScore >= 70 && totalScore <= 80){
					strength = "Strong";
				}else{
					strength = "Very Strong";
				}
				
				setStrengthDisplay(strength, totalScore, PercentLabel, strengthLabel);
			
			}
		});
		PasswordText.setBounds(75, 10, 170, 19);
		
	}
	
	///
	/// \brief countUppercase - given a string will return the number of uppercase
	/// characters.
	/// \param st - string to analyze
	///
	public int countUppercase(String pass){
		int count =0;
		for(int i=0;i<pass.length();i++){
			if(Character.isUpperCase(pass.charAt(i)))count++;
		}
		return count;
	}
	
	///
	/// \brief countLowercase - given a string will return the number of lowercase
	/// characters.
	/// \param st - string to analyze
	///
	public int countLowercase(String pass){
		int count=0;
		for(int i=0;i<pass.length();i++){
			if(Character.isLowerCase(pass.charAt(i)))count++;
		}
		return count;
	}
	
	///
	/// \brief countDigits - given a string will return the number of digits.
	/// \param st - string to analyze
	///
	public int countDigits(String pass){
		int count =0;
		 for(int i=0; i<pass.length();i++){
			if(Character.isDigit(pass.charAt(i)))count++;
		 }
		 return count;
	}
	
	///
	/// \brief countSymbols - given a string will return the number of symbols.
	/// \param st - string to analyze
	///
	public int countSymbols(String pass){
		int count =0;
		for(int i=0;i<pass.length();i++){
			if(!Character.isLetterOrDigit(pass.charAt(i)))count++;
		}
		return count;
	}
	
	///
	/// \brief middleDigitsOrSymbols - returns the number of digits and symbols
	/// that are not the first or last characters of the received string.
	/// \param st - string to analyze
	///
	public int middleDigitsOrSymbols(String pass){
		int midCount=0;
		boolean izqcheck = false;
		boolean dercheck = false;
		int poscounter = 0;
		
		if(pass.length()>=3){
			for(int i=0;i<pass.length();i++){
				if(Character.isDigit(pass.charAt(i)) || !Character.isLetter(pass.charAt(i))){
					if(!Character.isSpaceChar(pass.charAt(i))){
						poscounter = i-1;
						while(izqcheck == false && poscounter >= 0){
							if(!Character.isSpaceChar(pass.charAt(poscounter))){
								izqcheck = true;
							}else{
								poscounter--;
							}
						}
						poscounter = i+1;
						while(dercheck == false && poscounter < pass.length()){
							if(!Character.isSpaceChar(pass.charAt(poscounter))){
								dercheck=true;
							}else{
								poscounter++;
							}
						}
						if(izqcheck && dercheck){
							midCount++;
						}
						izqcheck = false;
						dercheck = false;
					}
				}
			}
		}
		return midCount;
	}
	
	///
	/// \brief consecUppercase - given a string will return the number of
	/// uppercase characters that follow a character of that same type.
	/// \param st - string to analyze
	///
	public int consecUppercase(String pass){
		int count=0;
		// prevSameType will be made true whenever we find a character
	    // of the type we are looking.
		boolean prevSameType= false;
		for(int i=0;i<pass.length();i++){
			if(Character.isUpperCase(pass.charAt(i))){
				if(prevSameType) count++;
				prevSameType = true;
			}else{
				prevSameType = false;
			}
		}
		return count;
	}
	
	///
	/// \brief consecLowercase - given a string will return the number of
	/// lowercase characters that follow a character of that same type.
	/// \param st - string to analyze
	///
	public int consecLowercase(String pass){
		int count=0;
		// prevSameType will be made true whenever we find a character
	    // of the type we are looking.
		boolean prevSameType= false;
		for(int i=0;i<pass.length();i++){
			if(Character.isLowerCase(pass.charAt(i))){
				if(prevSameType) count++;
				prevSameType = true;
			}else{
				prevSameType = false;
			}
		}
		return count;
	}
	
	///
	/// \brief consecDigits - given a string will return the number of
	/// digits that follow a digit.
	/// \param st - string to analyze
	///
	public int consecDigits(String pass){
		int count=0;
		// prevSameType will be made true whenever we find a character
	    // of the type we are looking.
		boolean prevSameType= false;
		for(int i=0;i<pass.length();i++){
			if(Character.isDigit(pass.charAt(i))){
				if(prevSameType) count++;
				prevSameType = true;
			}else{
				prevSameType = false;
			}
		}
		return count;
	}
	///
	/// \brief setLabels - sets the text labels on the UI
	///
	public void setLabels(int count, int score, Label countLabel, Label scoreLabel){
		scoreLabel.setText(String.valueOf(score));
		countLabel.setText(String.valueOf(count));
	}
	///
	/// Function which displays the strength of the
	/// password tested by the user
	///
	public void setStrengthDisplay(String strength, int totalScore, Label percentLabel, Label strengthLabel){
		if(totalScore > 100){
			totalScore = 100;
			percentLabel.setText(String.valueOf(totalScore) + "%");
		}else if(totalScore < 0){
			totalScore = 0;
			percentLabel.setText(String.valueOf(totalScore) + "%");
		}else{
			percentLabel.setText(String.valueOf(totalScore) + "%");
		}
		
		strengthLabel.setText(strength);
	}
}



