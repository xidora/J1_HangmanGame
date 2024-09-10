package edu.tartelette.hangman;

public class HangManArt {
    private static final String[] art = new String[] {
            """
    ═╦═════╦═
     ║     |
     ║
     ║
     ║
     ║
    ═╩═══════
""",
            """
    ═╦═════╦═
     ║     |
     ║     O
     ║
     ║
     ║
    ═╩═══════
""",
            """
    ═╦═════╦═
     ║     |
     ║     O
     ║    /
     ║
     ║
    ═╩═══════
""",
            """
    ═╦═════╦═
     ║     |
     ║     O
     ║    /|
     ║
     ║
    ═╩═══════
""",
            """
    ═╦═════╦═
     ║     |
     ║     O
     ║    /|\\
     ║
     ║
    ═╩═══════
""",
            """
    ═╦═════╦═
     ║     |
     ║     O
     ║    /|\\
     ║    /
     ║
    ═╩═══════
""",
            """
    ═╦═════╦═
     ║     |
     ║     O
     ║    /|\\
     ║    / \\
     ║
    ═╩═══════
"""
    };

    public HangManArt(String word) {
        System.out.println(word);
    }

    protected static void printHangManArt(int i) {
        System.out.print(art[6 - i]);
    }
}
