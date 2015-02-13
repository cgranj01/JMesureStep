
package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;

import org.hibernate.Session;

import serialization.Analyses;
import utilites.SingletonSession;
import utilites.Tools;

public class PrincipaleController implements Initializable
{
	@FXML
	private ImageView		logosap2i;
	@FXML
	private TextField		entmes;
	@FXML
	private TextField		entdco;
	@FXML
	private TextField		entdb05;
	@FXML
	private TextField		entppO4;
	@FXML
	private TextField		entntk;
	@FXML
	private TextField		entnh4;
	@FXML
	private TextField		entnno2;
	@FXML
	private TextField		entnno3;
	@FXML
	private TextField		entph;
	@FXML
	private TextField		entmes2;
	@FXML
	private TextField		entdco2;
	@FXML
	private TextField		entdb052;
	@FXML
	private TextField		entppO42;
	@FXML
	private TextField		entntk2;
	@FXML
	private TextField		entnh42;
	@FXML
	private TextField		entnno22;
	@FXML
	private TextField		entnno32;
	@FXML
	private TextField		entph2;
	@FXML
	private TextField		sormes;
	@FXML
	private TextField		sordco;
	@FXML
	private TextField		sordb05;
	@FXML
	private TextField		sorppO4;
	@FXML
	private TextField		sorntk;
	@FXML
	private TextField		sornh4;
	@FXML
	private TextField		sornno2;
	@FXML
	private TextField		sornno3;
	@FXML
	private TextField		sorph;
	@FXML
	private TextField		msent;
	@FXML
	private TextField		msot;
	@FXML
	private TextField		msaer;
	@FXML
	private TextField		msrecirc;
	@FXML
	private TextField		badec;
	@FXML
	private TextField		batemp;
	@FXML
	private TextField		basecc;

	@FXML
	private DatePicker		anadate;

	@FXML
	private Button			mettreajouranalyse;
	@FXML
	private Button			quitter;
	@FXML
	private Label			lblinfo;
	@FXML
	private Button			supprimer;

	private Session			singletonSession	= SingletonSession.getSession ();
	private final String	pattern				= "eee dd MMM yyyy";
	private Analyses		analyses;

	@Override
	public void initialize (URL location, ResourceBundle resources)
	{

	}

	public void quit (ActionEvent aAe)
	{
//		int rep = JOptionPane.showConfirmDialog (null, "Etes- vous sur de vouloir quitter", "Confirmation",
//				JOptionPane.OK_OPTION);
//
//		if (rep == 0)
			System.exit (0);

	}

	public int [] getDate () throws IllegalArgumentException
	{
		LocalDate date = Tools.testDate (this.anadate.getValue ());
		int [] tdate = {date.getDayOfMonth (), date.getMonthValue (), date.getYear ()};
		System.out.println (tdate [0] + " " + tdate [1] + " " + tdate [2]);
		return tdate;
	}

	public void lireanalyses (ActionEvent aAe)
	{
		StringConverter converter = new StringConverter<LocalDate> ()
		{
			DateTimeFormatter	dateFormatter	= DateTimeFormatter.ofPattern (pattern);

			@Override
			public String toString (LocalDate date)
			{
				if (date != null)
				{
					return dateFormatter.format (date);
				}
				else
				{
					return "";
				}
			}

			@Override
			public LocalDate fromString (String string)
			{
				if (string != null && ! string.isEmpty ())
				{
					return LocalDate.parse (string, dateFormatter);
				}
				else
				{
					return null;
				}
			}
		};
		this.anadate.setConverter (converter);
		this.anadate.setPromptText (pattern.toLowerCase ());

		try
		{
			int [] jma = this.getDate ();
			this.analyses = (Analyses) singletonSession.load (Analyses.class, new GregorianCalendar (jma [2],
					jma [1] - 1, jma [0]));
			this.entmes.setText (Tools.testNull ("" + analyses.getEntmes () + ""));
			this.entdco.setText (Tools.testNull ("" + analyses.getEntdco () + ""));
			this.entdb05.setText (Tools.testNull ("" + analyses.getEntdb05 () + ""));
			this.entppO4.setText (Tools.testNull ("" + analyses.getEntppO4 () + ""));
			this.entntk.setText (Tools.testNull ("" + analyses.getEntntk () + ""));
			this.entnh4.setText (Tools.testNull ("" + analyses.getEntnh4 () + ""));
			this.entnno2.setText (Tools.testNull ("" + analyses.getEntnno2 () + ""));
			this.entnno3.setText (Tools.testNull ("" + analyses.getEntnno3 () + ""));
			this.entph.setText (Tools.testNull ("" + analyses.getEntph () + ""));

			this.entmes2.setText (Tools.testNull ("" + analyses.getEntmes2 () + ""));
			this.entdco2.setText (Tools.testNull ("" + analyses.getEntdco2 () + ""));
			this.entdb052.setText (Tools.testNull ("" + analyses.getEntdb052 () + ""));
			this.entppO42.setText (Tools.testNull ("" + analyses.getEntppO42 () + ""));
			this.entntk2.setText (Tools.testNull ("" + analyses.getEntntk2 () + ""));
			this.entnh42.setText (Tools.testNull ("" + analyses.getEntnh42 () + ""));
			this.entnno22.setText (Tools.testNull ("" + analyses.getEntnno22 () + ""));
			this.entnno32.setText (Tools.testNull ("" + analyses.getEntnno32 () + ""));
			this.entph2.setText (Tools.testNull ("" + analyses.getEntph2 () + ""));

			this.sormes.setText (Tools.testNull ("" + analyses.getSormes () + ""));
			this.sordco.setText (Tools.testNull ("" + analyses.getSordco () + ""));
			this.sordb05.setText (Tools.testNull ("" + analyses.getSordb05 () + ""));
			this.sorppO4.setText (Tools.testNull ("" + analyses.getSorppO4 () + ""));
			this.sorntk.setText (Tools.testNull ("" + analyses.getSorntk () + ""));
			this.sornh4.setText (Tools.testNull ("" + analyses.getSornh4 () + ""));
			this.sornno2.setText (Tools.testNull ("" + analyses.getSornno2 () + ""));
			this.sornno3.setText (Tools.testNull ("" + analyses.getSornno3 () + ""));
			this.sorph.setText (Tools.testNull ("" + analyses.getSorph () + ""));

			this.msent.setText (Tools.testNull ("" + analyses.getMsent () + ""));
			this.msot.setText (Tools.testNull ("" + analyses.getMsot () + ""));
			this.msaer.setText (Tools.testNull ("" + analyses.getMsaer () + ""));
			this.msrecirc.setText (Tools.testNull ("" + analyses.getMsrecirc () + ""));
			this.badec.setText (Tools.testNull ("" + analyses.getBadec () + ""));
			this.batemp.setText (Tools.testNull ("" + analyses.getBatemp () + ""));
			this.basecc.setText (Tools.testNull ("" + analyses.getBasecc () + ""));
			
			this.lblinfo.setText ("");
			this.supprimer.setDisable (false);

		}
		catch (Exception aE)
		{
			this.remiseAblanc ();
			this.supprimer.setDisable (true);
			this.analyses = null;
		}
	}

	public void update (ActionEvent aAe)
	{
		try
		{
			int [] jma = this.getDate ();
			GregorianCalendar gc = new GregorianCalendar (jma [2], jma [1] - 1, jma [0]);
			if(this.analyses == null) this.analyses = new Analyses ();
			this.analyses.setAnadate (gc);
			this.analyses.setEntmes (Tools.testNumber (this.entmes.getText ()));
			this.analyses.setEntdco (Tools.testNumber (this.entdco.getText ()));
			this.analyses.setEntdb05 (Tools.testNumber (this.entdb05.getText ()));
			this.analyses.setEntppO4 (Tools.testNumber (this.entppO4.getText ()));
			this.analyses.setEntntk (Tools.testNumber (this.entntk.getText ()));
			this.analyses.setEntnh4 (Tools.testNumber (this.entnh4.getText ()));
			this.analyses.setEntnno2 (Tools.testNumber (this.entnno2.getText ()));
			this.analyses.setEntnno3 (Tools.testNumber (this.entnno3.getText ()));
			this.analyses.setEntph (Tools.testNumber (this.entph.getText ()));

			this.analyses.setEntmes2 (Tools.testNumber (this.entmes2.getText ()));
			this.analyses.setEntdco2 (Tools.testNumber (this.entdco2.getText ()));
			this.analyses.setEntdb052 (Tools.testNumber (this.entdb052.getText ()));
			this.analyses.setEntppO42 (Tools.testNumber (this.entppO42.getText ()));
			this.analyses.setEntntk2 (Tools.testNumber (this.entntk2.getText ()));
			this.analyses.setEntnh42 (Tools.testNumber (this.entnh42.getText ()));
			this.analyses.setEntnno22 (Tools.testNumber (this.entnno22.getText ()));
			this.analyses.setEntnno32 (Tools.testNumber (this.entnno32.getText ()));
			this.analyses.setEntph2 (Tools.testNumber (this.entph2.getText ()));

			analyses.setSormes (Tools.testNumber (this.sormes.getText ()));
			analyses.setSordco (Tools.testNumber (this.sordco.getText ()));
			analyses.setSordb05 (Tools.testNumber (this.sordb05.getText ()));
			analyses.setSorppO4 (Tools.testNumber (this.sorppO4.getText ()));
			analyses.setSorntk (Tools.testNumber (this.sorntk.getText ()));
			analyses.setSornh4 (Tools.testNumber (this.sornh4.getText ()));
			analyses.setSornno2 (Tools.testNumber (this.sornno2.getText ()));
			analyses.setSornno3 (Tools.testNumber (this.sornno3.getText ()));
			analyses.setSorph (Tools.testNumber (this.sorph.getText ()));

			analyses.setMsent (Tools.testNumber (this.msent.getText ()));
			analyses.setMsot (Tools.testNumber (this.msot.getText ()));
				
			analyses.setMsaer (Tools.testNumber (this.msaer.getText ()));
			analyses.setMsrecirc (Tools.testNumber (this.msrecirc.getText ()));
			analyses.setBadec (Tools.testNumber (this.badec.getText ()));
			analyses.setBatemp (Tools.testNumber (this.batemp.getText ()));
			analyses.setBasecc (Tools.testNumber (this.basecc.getText ()));

			this.singletonSession.persist (analyses);
			this.singletonSession.flush ();

			//JOptionPane.showMessageDialog (null, "Saisie validée !", "Saisie", JOptionPane.INFORMATION_MESSAGE);
			this.lblinfo.setText ("Saisie validée !");
			this.supprimer.setDisable (false);
		}
		catch (IllegalArgumentException aie)
		{
			//JOptionPane.showMessageDialog (null, aie.getMessage (), "Erreur saisie", JOptionPane.ERROR_MESSAGE);
			this.lblinfo.setText (aie.getMessage ());
		}

	}

	public void supp (ActionEvent aAe)
	{
		int [] jma = this.getDate ();
		Analyses analyses = (Analyses) this.singletonSession.load (Analyses.class, new GregorianCalendar (jma [2],
				jma [1] - 1, jma [0]));
		this.singletonSession.delete(analyses);
		this.singletonSession.flush ();
		this.lblinfo.setText ("Analyses à date supprimée");
		this.remiseAblanc ();
		this.supprimer.setDisable (true);
	}
	
	public void clearDate ()
	{
		this.anadate.setPromptText ("Sélectionner une date");
	}

	public void remiseAblanc ()
	{
		this.clearDate ();
		this.entmes.setText ("");
		this.entdco.setText ("");
		this.entdb05.setText ("");
		this.entppO4.setText ("");
		this.entntk.setText ("");
		this.entnh4.setText ("");
		this.entnno2.setText ("");
		this.entnno3.setText ("");
		this.entph.setText ("");

		this.entmes2.setText ("");
		this.entdco2.setText ("");
		this.entdb052.setText ("");
		this.entppO42.setText ("");
		this.entntk2.setText ("");
		this.entnh42.setText ("");
		this.entnno22.setText ("");
		this.entnno32.setText ("");
		this.entph2.setText ("");

		this.sormes.setText ("");
		this.sordco.setText ("");
		this.sordb05.setText ("");
		this.sorppO4.setText ("");
		this.sorntk.setText ("");
		this.sornh4.setText ("");
		this.sornno2.setText ("");
		this.sornno3.setText ("");
		this.sorph.setText ("");

		this.msent.setText ("");
		this.msot.setText ("");
		this.msaer.setText ("");
		this.msrecirc.setText ("");
		this.badec.setText ("");
		this.batemp.setText ("");
		this.basecc.setText ("");

	}

}
