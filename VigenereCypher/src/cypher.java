import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class cypher {

	protected Shell shell;
	private Text KeywordText;
	private Text PlainText;
	private Text CypherText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			cypher window = new cypher();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		KeywordText = new Text(shell, SWT.BORDER);
		KeywordText.setBounds(51, 33, 350, 19);
		
		Label KeywordLabel = new Label(shell, SWT.NONE);
		KeywordLabel.setBounds(51, 13, 59, 14);
		KeywordLabel.setText("Keyword: ");
		
		PlainText = new Text(shell, SWT.BORDER);
		PlainText.setBounds(51, 90, 156, 110);
		
		CypherText = new Text(shell, SWT.BORDER);
		CypherText.setBounds(245, 90, 156, 110);
		
		Label PlaintextLabel = new Label(shell, SWT.NONE);
		PlaintextLabel.setBounds(51, 70, 59, 14);
		PlaintextLabel.setText("Plaintext:");
		
		Label CyphertextLabel = new Label(shell, SWT.NONE);
		CyphertextLabel.setBounds(245, 70, 72, 14);
		CyphertextLabel.setText("Cyphertext:");
		
		Button EncodeButton = new Button(shell, SWT.NONE);
		EncodeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
	
				char c, cL, kL;
				int key_count =0;
				String message = PlainText.getText();
				String key = KeywordText.getText();
				StringBuilder newMessage = new StringBuilder();
				
				for(int i=0;i<message.length();i++){
					c = message.charAt(i);
					if(Character.isLetter(c)){
						if(Character.isLowerCase(c)){
							cL = 'a';
							kL = Character.toLowerCase(key.charAt(key_count));
						}else{
							cL = 'A';
							kL = Character.toUpperCase(key.charAt(key_count));
						}
						c = (char) ((c + kL - 2 * cL) % 26 + cL);
						key_count++;
						key_count = key_count % key.length();
					}
					newMessage.append(c);
				}
				CypherText.setText(newMessage.toString());
				
			}
		});
		EncodeButton.setBounds(113, 206, 94, 28);
		EncodeButton.setText("Encode");
		
		Button DecodeButton = new Button(shell, SWT.NONE);
		DecodeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				char c, cL, kL;
				int key_count=0;
				String message = CypherText.getText();
				String key = KeywordText.getText();
				StringBuilder newMessage = new StringBuilder();
				
				for(int i=0;i<message.length();i++){
					c = message.charAt(i);
					if(Character.isLetter(c)){
						if(Character.isLowerCase(c)){
							cL = 'a';
							kL = Character.toLowerCase(key.charAt(key_count));
						}else{
							cL='A';
							kL = Character.toUpperCase(key.charAt(key_count));
						}
						
						c = (char) ((26 + c - kL)% 26 + cL);
						newMessage.append(c);
						key_count++;
						key_count = key_count % key.length();
					}else{
						newMessage.append(message.charAt(i));
					}
					
				}
				PlainText.setText(newMessage.toString());
			}
		});
		DecodeButton.setText("Decode");
		DecodeButton.setBounds(307, 206, 94, 28);

	}

}
