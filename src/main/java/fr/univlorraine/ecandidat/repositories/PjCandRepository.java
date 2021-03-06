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
package fr.univlorraine.ecandidat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.univlorraine.ecandidat.entities.ecandidat.PieceJustif;
import fr.univlorraine.ecandidat.entities.ecandidat.PjCand;
import fr.univlorraine.ecandidat.entities.ecandidat.PjCandPK;

@Repository
public interface PjCandRepository extends JpaRepository<PjCand, PjCandPK> {
	
	public List<PjCand> findByIdIdPjAndCandidatureCandidatIdCandidatAndCandidatureFormationTemDematFormOrderByDatModPjCandDesc(Integer idPj, Integer idCandidat, Boolean temDematForm);
	
	public Long countByPieceJustif(PieceJustif pieceJustif);
}
