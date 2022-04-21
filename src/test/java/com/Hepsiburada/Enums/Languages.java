package com.Hepsiburada.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Languages {
    /**
     * Added few languages as samples. All languages should be added for a real-work framework
     */
    English("en"),
    Deutsch("de"),
    Francais("fr"),
    Latina("la");

    @Getter
    private String langCode;
}
