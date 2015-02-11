import java.util.Arrays;
import java.util.Vector;

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
		lblNumbers.setBounds(243, 154, 73, 14);
		lblNumbers.setText("Numbers:");
		
		final Label NumbersCount = new Label(shell, SWT.NONE);
		NumbersCount.setBounds(325, 154, 59, 14);
		NumbersCount.setText("0");
		
		final Label NumbersScore = new Label(shell, SWT.NONE);
		NumbersScore.setBounds(390, 154, 59, 14);
		NumbersScore.setText("0");
		
		Label lblSymbols = new Label(shell, SWT.NONE);
		lblSymbols.setBounds(247, 174, 59, 19);
		lblSymbols.setText("Symbols:");
		
		final Label SymbolsCount = new Label(shell, SWT.NONE);
		SymbolsCount.setBounds(325, 174, 59, 14);
		SymbolsCount.setText("0");
		
		final Label SymbolsScore = new Label(shell, SWT.NONE);
		SymbolsScore.setBounds(390, 174, 59, 14);
		SymbolsScore.setText("0");
		
		Label lblMiddleNumbersOr = new Label(shell, SWT.NONE);
		lblMiddleNumbersOr.setBounds(134, 194, 171, 14);
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
		lblLettersOnly.setBounds(222, 254, 83, 19);
		lblLettersOnly.setText("Letters Only:");
		
		final Label LettersOnlyCount = new Label(shell, SWT.NONE);
		LettersOnlyCount.setBounds(325, 254, 59, 14);
		LettersOnlyCount.setText("0");
		
		final Label LettersOnlyScore = new Label(shell, SWT.NONE);
		LettersOnlyScore.setBounds(390, 254, 59, 14);
		LettersOnlyScore.setText("0");
		
		Label lblNumbersOnly = new Label(shell, SWT.NONE);
		lblNumbersOnly.setBounds(211, 274, 94, 19);
		lblNumbersOnly.setText("Numbers Only:");
		
		final Label NumbersOnlyCount = new Label(shell, SWT.NONE);
		NumbersOnlyCount.setBounds(325, 274, 59, 14);
		NumbersOnlyCount.setText("0");
		
		final Label NumbersOnlyScore = new Label(shell, SWT.NONE);
		NumbersOnlyScore.setBounds(390, 274, 59, 14);
		NumbersOnlyScore.setText("0");
		
		Label lblCharacterscaseInsensitive = new Label(shell, SWT.NONE);
		lblCharacterscaseInsensitive.setBounds(99, 294, 210, 19);
		lblCharacterscaseInsensitive.setText("Repeat Characters (Case Insensitive):");
		
		final Label CharactersCount = new Label(shell, SWT.NONE);
		CharactersCount.setBounds(325, 294, 59, 14);
		CharactersCount.setText("0");
		
		final Label CharactersScore = new Label(shell, SWT.NONE);
		CharactersScore.setBounds(390, 294, 59, 14);
		CharactersScore.setText("0");
		
		Label lblConsecutiveUppercaseLetters = new Label(shell, SWT.NONE);
		lblConsecutiveUppercaseLetters.setBounds(120, 313, 189, 19);
		lblConsecutiveUppercaseLetters.setText("Consecutive Uppercase Letters:");
		
		final Label ConsecutiveUpperCount = new Label(shell, SWT.NONE);
		ConsecutiveUpperCount.setBounds(325, 314, 59, 14);
		ConsecutiveUpperCount.setText("0");
		
		final Label ConsecutiveUpperScore = new Label(shell, SWT.NONE);
		ConsecutiveUpperScore.setBounds(390, 314, 59, 14);
		ConsecutiveUpperScore.setText("0");
		
		Label lblConsecutiveLowecaseLetters = new Label(shell, SWT.NONE);
		lblConsecutiveLowecaseLetters.setBounds(120, 330, 185, 14);
		lblConsecutiveLowecaseLetters.setText("Consecutive Lowercase Letters: ");
		
		final Label ConsecutiveLowerCount = new Label(shell, SWT.NONE);
		ConsecutiveLowerCount.setBounds(325, 335, 59, 14);
		ConsecutiveLowerCount.setText("0");
		
		final Label ConsecutiveLowerScore = new Label(shell, SWT.NONE);
		ConsecutiveLowerScore.setBounds(390, 334, 59, 14);
		ConsecutiveLowerScore.setText("0");
		
		Label lblConsecutiveNumbers = new Label(shell, SWT.NONE);
		lblConsecutiveNumbers.setBounds(170, 350, 135, 14);
		lblConsecutiveNumbers.setText("Consecutive Numbers: ");
		
		final Label ConsecutiveNumCount = new Label(shell, SWT.NONE);
		ConsecutiveNumCount.setBounds(325, 350, 59, 14);
		ConsecutiveNumCount.setText("0");
		
		final Label ConsecutiveNumScore = new Label(shell, SWT.NONE);
		ConsecutiveNumScore.setBounds(390, 350, 59, 14);
		ConsecutiveNumScore.setText("0");
		
		Label lblSequentialLetters = new Label(shell, SWT.NONE);
		lblSequentialLetters.setBounds(193, 370, 118, 14);
		lblSequentialLetters.setText("Sequential Letters: ");
		
		final Label SequentialLettersCount = new Label(shell, SWT.NONE);
		SequentialLettersCount.setBounds(325, 370, 59, 14);
		SequentialLettersCount.setText("0");
		
		final Label SequentialLettersScore = new Label(shell, SWT.NONE);
		SequentialLettersScore.setBounds(390, 370, 59, 14);
		SequentialLettersScore.setText("0");
		
		Label lblSequentialNumbers = new Label(shell, SWT.NONE);
		lblSequentialNumbers.setBounds(181, 390, 124, 14);
		lblSequentialNumbers.setText("Sequential Numbers: ");
		
		final Label SecuentialNumCount = new Label(shell, SWT.NONE);
		SecuentialNumCount.setBounds(325, 390, 59, 14);
		SecuentialNumCount.setText("0");
		
		final Label SequentialNumScore = new Label(shell, SWT.NONE);
		SequentialNumScore.setBounds(390, 390, 59, 14);
		SequentialNumScore.setText("0");
		
		Label lblSequentialSymbols = new Label(shell, SWT.NONE);
		lblSequentialSymbols.setBounds(187, 410, 118, 14);
		lblSequentialSymbols.setText("Sequential Symbols: ");
		
		final Label SequentialSymCount = new Label(shell, SWT.NONE);
		SequentialSymCount.setBounds(325, 410, 59, 14);
		SequentialSymCount.setText("0");
		
		final Label SequentialSymScore = new Label(shell, SWT.NONE);
		SequentialSymScore.setBounds(390, 410, 59, 14);
		SequentialSymScore.setText("0");
		
		PasswordText = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		PasswordText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String pass = PasswordText.getText();
				
				pass.length();
						   
			    lengthCheck(pass, CharNumCountLabel, CharNumScoreLabel);
			    upperCheck(pass, UpperCount, UpperScore);
			    lowerCheck(pass, LowerCount, LowerScore);
			    numberCheck(pass, NumbersCount, NumbersScore);
			    symbolCheck(pass, SymbolsCount, SymbolsScore);
			    midCheck(pass, MidCount, MidScore);
			    strengthDisplay(PercentLabel);
			    reqCheck(pass, ReqCount, ReqScore);
			    //deductions
			    lettersOnly(pass, LettersOnlyScore, LettersOnlyCount);
			    numbersOnly(pass, NumbersOnlyScore, NumbersOnlyCount);
			    repeatChars(pass, CharactersScore, CharactersCount);
			    consUpper(pass, ConsecutiveUpperScore, ConsecutiveUpperCount);
			    consLower(pass, ConsecutiveLowerCount, ConsecutiveLowerScore);
			    consNumber(pass, ConsecutiveNumCount, ConsecutiveNumScore);
			    seqLetters(pass, SequentialLettersCount, SequentialLettersScore);
//			    seqNumbers(pass, SecuentialNumCount, SequentialNumScore);
//			    seqSymbols(pass, SequentialSymCount, SequentialSymScore);
			    
			    //System.out.println(pass);
			
			}
		});
		PasswordText.setBounds(75, 10, 170, 19);
		

	}
	public void strengthDisplay(Label percent){
		
		bools.totalScore = (bools.posScore-bools.negScore);
		
		if(bools.totalScore <= 100 && bools.totalScore >= 0){
			percent.setText(String.valueOf(bools.totalScore));
		}else 
			if(bools.totalScore > 100){
				bools.totalScore = 100;
				percent.setText(String.valueOf(bools.totalScore));
			}else
				if(bools.totalScore == 0){
					bools.totalScore = 0;
					percent.setText(String.valueOf(bools.totalScore));
				}
	}
	
	public void reqCheck(String pass, Label CountLabel, Label ScoreLabel){
		int reqcount = 0;
		int reqscore = 0;
		
		if(pass.length() >= 8) reqcount++;
		if(bools.haveUpper == true) reqcount++;
		if(bools.haveLower) reqcount++;
		if(bools.haveNums) reqcount++;
		if(bools.haveSyms) reqcount++;
		if(bools.haveMid) reqcount++;
		
		if(pass.length() >= 8 && reqcount >= 4){
			reqscore = reqcount * 2;
			bools.posScore = bools.posScore + reqscore;
		}
		
		CountLabel.setText(String.valueOf(reqcount));
		ScoreLabel.setText(String.valueOf(reqscore));
		
		
	}
	public void lengthCheck(String pass, Label CountLabel, Label ScoreLabel){
		int wordLengthScore=0;
		wordLengthScore = pass.length() * 4;
		bools.posScore = bools.posScore + wordLengthScore;
		int wordLength = pass.length();
		
		ScoreLabel.setText(String.valueOf(wordLengthScore));
		CountLabel.setText(String.valueOf(wordLength));
	}
	
	public void upperCheck(String pass, Label CountLabel, Label ScoreLabel){
		int uppercaseScore=0;
		int upperCount=0;
		
		for(int i = 0; i < pass.length();i++){
			if(Character.isUpperCase(pass.charAt(i))){
				upperCount++;
			}	
		}
		uppercaseScore = upperCount * 2;
		bools.posScore = bools.posScore + uppercaseScore;
		ScoreLabel.setText(String.valueOf(uppercaseScore));
		CountLabel.setText(String.valueOf(upperCount));
		if(upperCount > 0){
			bools.haveUpper = true;
		}else{
			bools.haveUpper = false;
		}
	}
	
	public void lowerCheck(String pass, Label CountLabel, Label ScoreLabel){
		int lowerScore=0;
		int lowerCount=0;
		
		for(int i=0;i<pass.length();i++){
			if(Character.isLowerCase(pass.charAt(i))){
				lowerCount++;
			}
		}
		lowerScore = lowerCount * 2;
		bools.posScore = bools.posScore + lowerScore;
		ScoreLabel.setText(String.valueOf(lowerScore));
		CountLabel.setText(String.valueOf(lowerCount));
		if(lowerCount > 0){
			bools.haveLower = true;
		}else{
			bools.haveLower = false;
		}
	}
	
	public void numberCheck(String pass, Label CountLabel, Label ScoreLabel){
		int numberScore=0;
		int numberCount=0;
		
		for(int i=0;i<pass.length();i++){
			if(Character.isDigit(pass.charAt(i))){
				numberCount++;
			}
		}
		numberScore = numberCount * 4;
		bools.posScore = bools.posScore + numberScore;
		CountLabel.setText(String.valueOf(numberCount));
		ScoreLabel.setText(String.valueOf(numberScore));
		if(numberCount > 0){
			bools.haveNums = true;
		}else{
			bools.haveNums = false;
		}
	}
	
	public void symbolCheck(String pass, Label CountLabel, Label ScoreLabel){
		int symbolScore=0;
		int symbolCount=0;
		
		for(int i=0;i<pass.length();i++){
			if(!Character.isLetter(pass.charAt(i)) && !Character.isDigit(pass.charAt(i))){
				if(!Character.isSpaceChar(pass.charAt(i))){
				symbolCount++;
				}
			}
		}
		symbolScore = symbolCount * 6;
		bools.posScore = bools.posScore + symbolScore;
		ScoreLabel.setText(String.valueOf(symbolScore));
		CountLabel.setText(String.valueOf(symbolCount));
		if(symbolCount > 0){
			bools.haveSyms = true;
		}else{
			bools.haveSyms = false;
		}
	}
	
	public void midCheck(String pass, Label CountLabel, Label ScoreLabel){
		int midScore=0;
		int midCount=0;
		boolean midBool= false;
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
							midBool=true;
						}
						izqcheck = false;
						dercheck = false;
					}
				}
			}
		}
		if(midBool){
			midScore = midCount * 2;
			bools.posScore = bools.posScore + midScore;
			ScoreLabel.setText(String.valueOf(midScore));
			
		}else{
			midScore = 0;
			bools.posScore = bools.posScore + midScore;
			ScoreLabel.setText(String.valueOf(midScore));
		}
		if(midCount > 0){
			bools.haveMid = true;
		}else{
			bools.haveMid = false;
		}
		CountLabel.setText(String.valueOf(midCount));
	}
	
	public void lettersOnly(String pass, Label ScoreLabel, Label CountLabel){
		int lettersCounter = 0;
		boolean lettersBool = false;
		int izqSpace =0;
		int derSpace = 0;
		boolean izqfoundLetter = false;
		boolean derfoundLetter = false;
		
		for(int i=0;i<pass.length();i++){
			if(Character.isLetter(pass.charAt(i))){
				lettersCounter++;
				lettersBool = true;
			}else if(Character.isSpaceChar(pass.charAt(i))){
				izqSpace = i-1;
				derSpace = i+1;
				izqfoundLetter = false;
				derfoundLetter = false;
				while(izqSpace >= 0 && !izqfoundLetter){
					if(Character.isLetter(pass.charAt(izqSpace))){
						izqfoundLetter = true;
					}else{
						izqSpace--;
					}
				}
				while(derSpace < pass.length() && !derfoundLetter){
					if(Character.isLetter(pass.charAt(derSpace))){
						derfoundLetter = true;
					}else{
						derSpace++;
					}
				}
				if(derfoundLetter || izqfoundLetter){
					lettersCounter++;
					lettersBool = true;
				}
			}else{
				lettersBool = false;
				break;
			}
		}
		if(lettersBool){
			ScoreLabel.setText("-" + String.valueOf(lettersCounter));
			CountLabel.setText(String.valueOf(lettersCounter));
			bools.negScore = bools.negScore + lettersCounter;
		}else{
			lettersCounter = 0;
			ScoreLabel.setText("-" + String.valueOf(lettersCounter));
			CountLabel.setText(String.valueOf(lettersCounter));
			bools.negScore = bools.negScore + lettersCounter;
		}
	}
	
	public void numbersOnly(String pass, Label ScoreLabel, Label CountLabel){
		int numCounter = 0;
		boolean numBool = false;
		int izqNumSpace = 0;
		int derNumSpace = 0;
		boolean izqfoundNum = false;
		boolean derfoundNum = false;
		
		for(int i = 0;i<pass.length();i++){
			if(Character.isDigit(pass.charAt(i))){
				numCounter++;
				numBool = true;
			}else if(Character.isSpaceChar(pass.charAt(i))){
				izqNumSpace = i-1;
				derNumSpace = i+1;
				izqfoundNum = false;
				derfoundNum = false;
				
				while(izqNumSpace >= 0 && !izqfoundNum){
					if(Character.isDigit(pass.charAt(izqNumSpace))){
						izqfoundNum = true;
					}else{
						izqNumSpace--;
					}
				}
				while(derNumSpace < pass.length() && !derfoundNum){
					if(Character.isDigit(pass.charAt(derNumSpace))){
						derfoundNum = true;
					}else{
						derNumSpace++;
					}
				}
				if(derfoundNum || izqfoundNum){
					numCounter++;
					numBool = true;
				}
			}else{
				numBool = false;
				break;
			}
		}
		
		if(numBool){
			ScoreLabel.setText("-" + String.valueOf(numCounter));
			CountLabel.setText(String.valueOf(numCounter));
			bools.negScore = bools.negScore + numCounter;
		}else{
			numCounter = 0;
			ScoreLabel.setText("-" + String.valueOf(numCounter));
			CountLabel.setText(String.valueOf(numCounter));
			bools.negScore = bools.negScore + numCounter;
		}
	}
	
	public void repeatChars(String pass, Label ScoreLabel, Label CountLabel){
		int repCount =0;
		int[] coconut = new int[256];
		
		for(int i=0;i<pass.length();i++){
			coconut[pass.charAt(i)]++;
		}
		
		for(int i=0;i<coconut.length;i++){
			if(coconut[i] >= 2){
				repCount = repCount + coconut[i];
			}
		}
		CountLabel.setText(String.valueOf(repCount));
		int score = repCount * 2;
		ScoreLabel.setText(String.valueOf(score));
		bools.negScore = bools.negScore + score;

	}
	
	int countRepeated(String pass){
		int ctr = 0;
		
		boolean prevSameType = false;
		boolean isSomething = false;
		
		for(int i=0;i<pass.length();i++){
			if(Character.isUpperCase(pass.charAt(i))){
				isSomething = Character.isUpperCase(pass.charAt(i));
			}else if(Character.isLowerCase(pass.charAt(i))){
				isSomething = Character.isLowerCase(pass.charAt(i));
			}else if(Character.isDigit(pass.charAt(i))){
				isSomething = Character.isDigit(pass.charAt(i));
			}
			if(isSomething){
				if(prevSameType) ctr++;
				prevSameType = true;
			}else{
				prevSameType = false;
			}
		}
		return ctr;
	}
	
	
	void consUpper(String pass, Label ScoreLabel, Label CountLabel){
		
		int tc = 0;
		int c = 0;
		int score = 0;
		
		for(int i=0;i<pass.length();i++){
			if(Character.isUpperCase(pass.charAt(i))){
				tc++;
				if(tc>=2){
					c++;
					CountLabel.setText(String.valueOf(c));
					score = c * 2;
					ScoreLabel.setText(String.valueOf(score));
				}
			}else{
				tc = 0;
			}
		}
		bools.negScore = bools.negScore + score;
	}
	
	
	void consLower(String pass, Label CountLabel, Label ScoreLabel){
		
		int tc = 0;
		int c = 0;
		int score = 0;
		
		for(int i=0;i<pass.length();i++){
			if(Character.isLowerCase(pass.charAt(i))){
				tc++;
				if(tc>=2){
					c++;
					CountLabel.setText(String.valueOf(c));
					score = c * 2;
					ScoreLabel.setText(String.valueOf(score));
				}
			}else{
				tc = 0;
			}
		}
		bools.negScore = bools.negScore + score;
	}
	
	void consNumber(String pass, Label CountLabel, Label ScoreLabel){
		int tc = 0;
		int c = 0;
		int score = 0;
		
		for(int i=0;i<pass.length();i++){
			if(Character.isDigit(pass.charAt(i))){
				tc++;
				if(tc>=2){
					c++;
					CountLabel.setText(String.valueOf(c));
					score = c * 2;
					ScoreLabel.setText(String.valueOf(score));
				}
			}else{
				tc = 0;
			}
		}
		bools.negScore = bools.negScore + score;		
	}
	
	
	void seqLetters(String pass, Label CountLabel, Label ScoreLabel){
		int seqCounter =0;
		int counter =1;
		int pos=0;
		char in ='a';
		char out = 'A';
		char test2='z';
		
		char test=' ';
		char letter = ' ';
		int j = 0;
		int count = 0;
		int score = 0;
		int totalCount=0;
		int x=0;
		
		for(int i=0;i<pass.length();i++){
			if(Character.isLetter(pass.charAt(i))){
				//System.out.print("i: " + i + "! ");
				j=i;
				x=i;
				//System.out.print("j: " + j + "! ");
				letter = pass.charAt(i);
				if(letter == 'z' || letter == 'Z'){
//					while((char)((letter+j)%26) == pass.charAt(j)){
//						count++;
//						j++;
//						if(count >= 2) score++;
//					}
				}else{
					//System.out.print("letter: " + letter + " ");
					//System.out.print("letter+J:" + (char)(letter+j) + " pass[j]:" + pass.charAt(j) + " ");
					//System.out.print("j: " + j + " ");
					while((char)(letter+j) == pass.charAt(x)){
						j++;
						x++;
						count++;
						//System.out.print("(count:" + count + ")");
						if(count>=3){
							totalCount++;
							score= score - 3;
							System.out.print("score: " + score + "!");
							System.out.print("TotalCount: " + totalCount + "!");
							i=count+i;
							//System.out.print("(i inside if: " + i +") ");
						}
						if(j>=pass.length()){
							j=0;
							break;
						}
					}
					j=0;
					//System.out.print("count after while: " + count);
					count=0;
				}
			}
		}
		
//		//System.out.print(test2);
//		test2 = (char)((test2+1)%26);
//		System.out.print(test2);
		
		char[] abc = new char[52];
		
		for(int i=0;i<abc.length-26;i++){
			abc[i] = in;
			in = (char) (in + 1);
		}
		
		for(int i=26;i<abc.length;i++){
			abc[i] = out;
			out = (char)(out + 1);
		}
		
		
		
		//System.out.print(Arrays.toString(abc));
		
		
//		int seqCounter =0;
//		int counter =1 ;
//		int pos = 0; 
//		boolean yes = true;
//		boolean izqCheck = true;
//		
//		//seqcounter = countSequential(toUpperString(pass)), isuppper);
//		
//		for(int i=0; i < pass.length();i++){
//			if(Character.isLetter(pass.charAt(i))){
//				pos = i+1;
//				yes = true;
//				while(yes && counter < 3){
//					if(Character.toLowerCase(pass.charAt(pos)) == Character.toLowerCase(pass.charAt(pos-1)+1)){
//						counter++;
//						pos++;
//					}else{
//						yes=false;
//					}
//				}
//				
//				if(!yes){
//					izqCheck = true;
//					counter = 1;
//					pos = i+1;
//					while(izqCheck && counter < 3){
//						if(Character.toLowerCase(pass.charAt(pos))==Character.toLowerCase(pass.charAt(pos-1)-1)){
//							counter++;
//							pos++;
//						}else{
//							izqCheck=false;
//						}
//					}
//				}
//				if(counter == 3){
//					seqCounter++;
//				}
//				counter = 1;
//			}
//		}
//		
//		CountLabel.setText(String.valueOf(seqCounter));
//		int score = seqCounter * 3;
//		ScoreLabel.setText(String.valueOf(score));
//		bools.negScore = bools.negScore + score;
//		
//		if(seqCounter == 0){
//			CountLabel.setText(String.valueOf(seqCounter));
//			score = seqCounter * 3;
//			ScoreLabel.setText(String.valueOf(score));
//		}else{
//			CountLabel.setText(String.valueOf(seqCounter));
//			score = seqCounter * 3;
//			ScoreLabel.setText(String.valueOf(score));
//		}
	}
	
	void seqNum(String pass, Label CountLabel, Label ScoreLabel){
		
	}
	
	void seqSym(String pass, Label CountLabel, Label ScoreLabel){
		
	}
	
	
}



