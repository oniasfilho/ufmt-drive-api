package io.oniasfilho.ufmtdrive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteRespDTO {
    private Long note_id;
    private String note_title;
    private String note_description;
    private Long user;
}
