/**
 * ESUP-Portail eCandidat - Copyright (c) 2016 ESUP-Portail consortium
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.univlorraine.ecandidat.services.siscol;

import java.io.InputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import fr.univlorraine.ecandidat.services.siscol.SiScolRestUtils.SiScolResponseErrorHandler;
import fr.univlorraine.ecandidat.services.siscol.SiScolRestUtils.SiScolRestException;

/**
 * Class utilitaire des services rest de l'AMUE
 * @author Kevin Hergalant
 */
@Component
public class SiScolRestServiceInterface {

	/**
	 * @param  url
	 * @param  service
	 * @param  klass
	 * @param  mapGetParameter
	 * @return                 une liste d'objets pour un service donné
	 * @throws SiScolException
	 */
	public <T> List<T> getList(final String url, final String service, final Class<T[]> klass, final MultiValueMap<String, String> mapGetParameter) throws SiScolRestException, SiScolException {
		try {
			URI targetUrl = SiScolRestUtils.getURIForService(url, service, mapGetParameter);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.setErrorHandler(new SiScolResponseErrorHandler());
			T[] ret = restTemplate.getForObject(targetUrl, klass);
			List<T> liste = Arrays.asList(ret);
			return liste;
		} catch (SiScolRestException e) {
			throw e;
		} catch (Exception e) {
			throw new SiScolException("Erreur a l'appel du WS Rest des PJ", e);
		}
	}

	/**
	 * @param  url
	 * @param  service
	 * @param  mapGetParameter
	 * @return                     l'input stream de la piece
	 * @throws SiScolRestException
	 * @throws SiScolException
	 */
	public InputStream getFile(final String url, final String service, final MultiValueMap<String, String> mapGetParameter) throws SiScolRestException, SiScolException {
		try {
			URI targetUrl = SiScolRestUtils.getURIForService(url, service, mapGetParameter);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.setErrorHandler(new SiScolResponseErrorHandler());
			restTemplate.getMessageConverters().add(new ResourceHttpMessageConverter());
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
			HttpEntity<String> entity = new HttpEntity<>(headers);

			ResponseEntity<Resource> response = restTemplate.exchange(targetUrl, HttpMethod.GET, entity, Resource.class);
			return response.getBody().getInputStream();
		} catch (SiScolRestException e) {
			throw e;
		} catch (Exception e) {
			throw new SiScolException("Erreur a l'appel du WS Rest des PJ", e);
		}
	}
}
