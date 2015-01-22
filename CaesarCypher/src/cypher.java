import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class cypher {

	protected Shell shell;
	private Text PlainText;
	private Text CipherText;

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
		shell.setText("Caesar Cypher");
		
		PlainText = new Text(shell, SWT.BORDER);
		PlainText.setBounds(34, 93, 150, 100);
		
		CipherText = new Text(shell, SWT.BORDER);
		CipherText.setBounds(255, 93, 150, 100);
		
		final Spinner spinbox = new Spinner(shell, SWT.BORDER);
		spinbox.setBounds(171, 30, 98, 22);
		
		Label PlainTextLabel = new Label(shell, SWT.NONE);
		PlainTextLabel.setBounds(34, 73, 59, 14);
		PlainTextLabel.setText("Plain text");
		
		Label CipherTextLabel = new Label(shell, SWT.NONE);
		CipherTextLabel.setBounds(255, 73, 70, 14);
		CipherTextLabel.setText("Cipher text");
		
		Label SpinBoxLabel = new Label(shell, SWT.NONE);
		SpinBoxLabel.setBounds(171, 10, 107, 14);
		SpinBoxLabel.setText("Shifts to the right:");
		
		Button EncodeButton = new Button(shell, SWT.NONE);
		EncodeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				char c;
				char cL;
				int shift2right = Integer.parseInt(spinbox.getText());
				String message = PlainText.getText();
				StringBuilder newMessage = new StringBuilder();
				
				for(int i=0; i < message.length();i++){
					c = message.charAt(i); 
					if(Character.isLetter(c)){
						if(Character.isLowerCase(c)){
							cL = 'a';
						}else{
							cL = 'A';
						}
						c = (char) ((c - cL + shift2right) % 26 + cL);
					}
					newMessage.append(c);
				}
				CipherText.setText(newMessage.toString());
			}
		});
		EncodeButton.setBounds(90, 199, 94, 28);
		EncodeButton.setText("Encode");
		
		Button DecodeButton = new Button(shell, SWT.NONE);
		DecodeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				char c;
				char cL = 'a';
				String message = CipherText.getText();
				StringBuilder newMessage = new StringBuilder();
				int shift2right = Integer.parseInt(spinbox.getText());
				
				for(int i=0;i<message.length();i++){
					c = message.charAt(i);
					if(Character.isLetter(c)){
						if(Character.isLowerCase(c)){
							cL = 'a';
						}else{
							cL = 'A';
						}
						c = (char) (((c -cL - shift2right) + 26) % 26  + cL);
					}
					newMessage.append(c);
				}
				PlainText.setText(newMessage.toString());
			}
		});
		DecodeButton.setBounds(311, 199, 94, 28);
		DecodeButton.setText("Decode");

	}
}
