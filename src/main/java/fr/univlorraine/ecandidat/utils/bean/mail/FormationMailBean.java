/**
 *  ESUP-Portail eCandidat - Copyright (c) 2016 ESUP-Portail consortium
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package fr.univlorraine.ecandidat.utils.bean.mail;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class pour l'envoie de mail pôur les compteMinima
 * 
 * @author Kevin
 */
@Data
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = false)
public class FormationMailBean extends MailBean {

	private String code;
	private String libelle;
	private String codEtpVetApo;
	private String codVrsVetApo;
	private String libApo;
	private String motCle;
	private String datPubli;
	private String datPreAnalyse;
	private String datRetour;
	private String datJury;
	private String datConfirm;
	private String datDebDepot;
	private String datFinDepot;

	public FormationMailBean() {
		super();
	}

}
