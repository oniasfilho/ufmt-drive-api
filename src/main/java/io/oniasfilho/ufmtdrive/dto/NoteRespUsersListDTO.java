package io.oniasfilho.ufmtdrive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteRespUsersListDTO {
    private String note_title;
    private String note_description;
}
