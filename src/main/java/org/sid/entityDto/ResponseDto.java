package org.sid.entityDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
private CoursDto cours; 
private TypeContenuDTo typecontenu;
private EnseignantDto enseignantDto;
}
