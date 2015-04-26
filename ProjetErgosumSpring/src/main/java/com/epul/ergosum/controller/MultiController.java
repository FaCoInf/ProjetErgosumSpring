package com.epul.ergosum.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.MappingException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.epul.ergosum.dao.CatalogueDAO;
import com.epul.ergosum.dao.CategorieDAO;
import com.epul.ergosum.dao.JouetDAO;
import com.epul.ergosum.dao.TrancheageDAO;
import com.epul.ergosum.model.Catalogue;
import com.epul.ergosum.model.Categorie;
import com.epul.ergosum.model.Jouet;
import com.epul.ergosum.model.Trancheage;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MultiController extends MultiActionController {

	private static final Logger	logger	= LoggerFactory.getLogger(MultiController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private Jouet				unJouet;

	@Autowired
	protected JouetDAO			jouetDAO;
	@Autowired
	protected CategorieDAO		categorieService;
	@Autowired
	protected CatalogueDAO		catalogueService;
	@Autowired
	protected TrancheageDAO		trancheageService;

	// protected JouetService jouetService;
	//
	// protected CategorieService categorieService;
	//
	// protected CatalogueService catalogueService;
	//
	// protected TrancheageService trancheageService;

	// @PostConstruct
	// public void setServices(){
	// jouetService = new JouetServiceImpl();
	// categorieService = new CategorieServiceImpl();
	// catalogueService = new CatalogueServiceImpl();
	// trancheageService = new TrancheageServiceImpl();
	// }

	/**
	 * 
	 * Affichage de la page d'accueil
	 */
	@RequestMapping(value = "index.htm", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "/index";
	}

	/**
	 * Affichage de tous les jouets
	 */
	@RequestMapping(value = "afficherJouets.htm")
	public ModelAndView afficherLesJouets(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {

			int categorieCode;
			int trancheCode;
			String categorie = request.getParameter("codecateg");
			String tranche = request.getParameter("codetranche");
			if (categorie == null && tranche == null) {
				categorieCode = 0;
				trancheCode = 0;
			} else {
				categorieCode = Integer.parseInt(categorie);
				trancheCode = Integer.parseInt(tranche);
			}

			List<Jouet> jouets = jouetDAO.getAllJouet(); // get en fonction code
															// & tranche
			request.setAttribute("mesJouets", jouets);
			request.setAttribute("listCategorie", categorieService.getAllCategorie());
			request.setAttribute("listTrancheAge", trancheageService.getAllTranchage());

			return new ModelAndView("ListerJouets");
		} catch (MappingException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			e.printStackTrace();
		}
		destinationPage = "/ListerJouets";

		return new ModelAndView(destinationPage);
	}

	/**
	 * Ajout d'un jouet
	 */
	@RequestMapping(value = "ajouterJouet.htm")
	public ModelAndView ajoutJouet(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";

		try {

			// on passe les num�ros de client et de vendeur
			request.setAttribute("jouet", new Jouet());

			request.setAttribute("listCategorie", categorieService.getAllCategorie());
			request.setAttribute("listTrancheAge", trancheageService.getAllTranchage());
			request.setAttribute("listCatalogue", catalogueService.getAllCatalogue());

			request.setAttribute("title", "Ajouter un jouet");
			request.setAttribute("textButton", "Ajouter");
			request.setAttribute("action", "sauverJouet");
			request.setAttribute("page", "sauverJouet.htm");

			destinationPage = "/SaisieJouet";
		} catch (MappingException e) {
			request.setAttribute("MesErreurs", e.getMessage());
			e.printStackTrace();
		}

		return new ModelAndView(destinationPage);
	}

	/**
	 * Sauver jouet
	 */
	@RequestMapping(value = "sauverJouet.htm")
	public ModelAndView sauverJouet(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "/Erreur";
		try {
			String id = request.getParameter("id");
			// GestionErgosum unService = new GestionErgosum();
			// if (unService != null) {

			// fabrication du jouet � partir des param�tres de la requ�te
			// Si le jouet n'est pas � cr�er, il faut le r�cup�rer de la
			// session
			// courante
			// Ensuite on peut modifier ses champs

			if (request.getParameter("type").equals("sauverJouet")) {
				unJouet = new Jouet();
			} else { // on r�cup�re le jouet courant

				unJouet = jouetDAO.getJouet(id);
			}
			unJouet.setNumero(request.getParameter("id"));
			unJouet.setLibelle(request.getParameter("libelle"));
			System.out.println("codecateg=" + request.getParameter("codecateg"));
			System.out.println("codetranche=" + request.getParameter("codetranche"));
			Categorie uneCateg = categorieService.getCategorie(request.getParameter("codecateg"));
			unJouet.setCategorie(uneCateg);

			Trancheage uneTranche = trancheageService.getTrancheage(request.getParameter("codetranche"));
			unJouet.setTrancheage(uneTranche);

			// sauvegarde du jouet
			if (request.getParameter("type").equals("modifierJouet")) {
				jouetDAO.modifyJouet(unJouet);
			} else {

				Catalogue leCatalogue = catalogueService.getCatalogue(Integer.parseInt(request.getParameter("codecatalogue")));
				System.out.println("Je suis � la quantit� ");
				;
				System.out.println("codecatalogue=" + request.getParameter("codecatalogue"));

				System.out.println("quantiteDistribution=" + request.getParameter("quantiteDistribution"));

				int quantiteDistribution = Integer.parseInt(request.getParameter("quantiteDistribution"));
				if (quantiteDistribution > 0) {
					leCatalogue.setQuantiteDistribuee(leCatalogue.getQuantiteDistribuee() + quantiteDistribution);
					catalogueService.modifyCatalogue(leCatalogue);
				}
				jouetDAO.addJouet(unJouet);
			}
			try {
				request.setAttribute("mesJouets", jouetDAO.getAllJouet());
				destinationPage = "/ListerJouets";
			} catch (MappingException e) {
				request.setAttribute("MesErreurs", e.getMessage());
				e.printStackTrace();
			}

			// }
			request.setAttribute("mesJouets", jouetDAO.getAllJouet());
			destinationPage = "/ListerJouets";
		} catch (ConstraintViolationException ex) {
			request.setAttribute("MesErreurs", "Le numéro est déjà utilisé");
			
			request.setAttribute("jouet", unJouet);
			request.setAttribute("title", "Ajouter un jouet");
			request.setAttribute("textButton", "Ajouter");
			request.setAttribute("action", "sauverJouet");
			request.setAttribute("page", "sauverJouet.htm");
			request.setAttribute("listCategorie", categorieService.getAllCategorie());
			request.setAttribute("listTrancheAge", trancheageService.getAllTranchage());
			request.setAttribute("listCatalogue", catalogueService.getAllCatalogue());

			destinationPage = "/SaisieJouet";

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("MesErreurs", e.getMessage());
		}

		return new ModelAndView(destinationPage);
	}

	/**
	 * Modifier Jouet
	 */
	@RequestMapping(value = "modifierJouet.htm")
	public ModelAndView modifierJouet(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "Erreur";
		try {
			String id = request.getParameter("id");
			// GestionErgosum unService = new GestionErgosum();
			//
			// if (unService != null) {
			Jouet unJouet = jouetDAO.getJouet(id);
			request.setAttribute("jouet", unJouet);
			// request.setAttribute("categories",
			// unService.listerToutesLesCategories());
			// request.setAttribute("tranches",
			// unService.listerToutesLesTranches());
			request.setAttribute("listCategorie", categorieService.getAllCategorie());
			request.setAttribute("listTrancheAge", trancheageService.getAllTranchage());
			request.setAttribute("listCatalogue", catalogueService.getAllCatalogue());

			request.setAttribute("title", "Modifier le jouet");
			request.setAttribute("textButton", "Modifier");
			request.setAttribute("action", "modifierJouet");
			request.setAttribute("page", "sauverJouet.htm");

			destinationPage = "/ModifierJouet";
			// }

		} catch (MappingException e) {
			e.printStackTrace();
			request.setAttribute("MesErreurs", e.getMessage());
		}

		return new ModelAndView(destinationPage);
	}

	/**
	 * effacer jouet
	 */
	@RequestMapping(value = "effacerJouet.htm")
	public ModelAndView effacerJouet(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "";
		try {
			String id = request.getParameter("id");
			// GestionErgosum unService = new GestionErgosum();
			//
			// if (unService != null) {
			// recuperation de la liste des id a effacer
			String[] ids = request.getParameterValues("id");

			// effacement de la liste des id
			if (ids != null) {
				// unService.effacer(ids);
				for (int i = 0; i < ids.length; i++) {
					jouetDAO.suppressJouet(ids[i]);
				}
			}
			// preparation de la liste
			request.setAttribute("mesJouets", jouetDAO.getAllJouet());
		}

		catch (MappingException e) {
			e.printStackTrace();
			request.setAttribute("MesErreurs", e.getMessage());
		}

		destinationPage = "/ListerJouets";
		return new ModelAndView(destinationPage);
	}

	// /**
	// * Sélection d'une année par catégorie
	// */
	// @RequestMapping(value = "selectionnerAnnee.htm")
	// public ModelAndView selectionAnnee(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	//
	// String destinationPage = "";
	// destinationPage = "/selectCionAnneeCat";
	// return new ModelAndView(destinationPage);
	// }

	/**
	 * Sélection d'une année Ctagoriet
	 */
	@RequestMapping(value = "listerCatalogues.htm")
	public ModelAndView choixCatalogue(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "/Erreur";
		try {
			// GestionErgosum unService = new GestionErgosum();
			//
			// if (unService != null)
			// request.setAttribute("catalogues",
			// unService.listerTousLesCatalogues());
			destinationPage = "/ChoixCatalogue";
		} catch (MappingException e) {
			e.printStackTrace();
			request.setAttribute("MesErreurs", e.getMessage());
		}

		return new ModelAndView(destinationPage);
	}

	/**
	 * afficher Catalogue
	 */
	@RequestMapping(value = "afficherCatalogues.htm")
	public ModelAndView afficherCatalogue(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "/Erreur";
		try {
			String id = request.getParameter("id");
			System.out.println(request.getParameter("anneeDebut"));
			System.out.println(request.getParameter("nbAnnees"));
			// GestionErgosum unService = new GestionErgosum();
			//
			// if (unService != null) {
			// preparation de la liste
			// request.setAttribute("mesCataloguesQuantites", unService
			// .listerCatalogueQuantites(Integer.parseInt(request
			// .getParameter("anneeDebut")), Integer
			// .parseInt(request.getParameter("nbAnnees"))));
			destinationPage = "/ListerCatalogues";
			// }
		}

		catch (MappingException e) {
			e.printStackTrace();
			request.setAttribute("MesErreurs", e.getMessage());
		}

		return new ModelAndView(destinationPage);
	}

	/**
	 * afficher le Dictionnaire
	 */
	@RequestMapping(value = "afficherDictionnaire.htm")
	public ModelAndView afficherDictionnaire(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String destinationPage = "/Erreur";
		try {
			String annee = request.getParameter("anneecatalogue");
			System.out.println(request.getParameter("anneecatalogue"));

			request.setAttribute("listCatalogue", catalogueService.getAllCatalogue());
			// GestionErgosum unService = new GestionErgosum();

			// if (unService != null) {
			//
			// HashMap<Categorie, Integer> hashCatInt = unService
			// .rechercherDictionnaire(request.getParameter("annee"));
			// request.setAttribute("dictionnaire", hashCatInt);
			request.setAttribute("anneecatalogue", annee);
			destinationPage = "/ListerDictionnaire";
			// }
		}

		catch (MappingException e) {
			e.printStackTrace();
			request.setAttribute("MesErreurs", e.getMessage());
		}

		return new ModelAndView(destinationPage);
	}

}