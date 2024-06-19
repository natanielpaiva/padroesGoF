package exemplos;

import java.util.ArrayList;
import java.util.List;

// Interface Command
interface CommandInterface {
    void execute();
}

// Implementações concretas de comandos
class CopyCommand implements CommandInterface {
    private Editor editor;

    public CopyCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.copy();
    }
}

class PasteCommand implements CommandInterface {
    private Editor editor;

    public PasteCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.paste();
    }
}

class UndoCommand implements CommandInterface {
    private Editor editor;

    public UndoCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.undo();
    }
}

// Classe Editor (Recebe comandos)
class Editor {
    public void copy() {
        System.out.println("Copying text...");
    }

    public void paste() {
        System.out.println("Pasting text...");
    }

    public void undo() {
        System.out.println("Undoing last action...");
    }
}

// Classe Invoker (Invoca comandos)
class CommandInvoker {
    private List<CommandInterface> commandHistory = new ArrayList<>();

    public void executeCommand(CommandInterface command) {
        commandHistory.add(command);
        command.execute();
    }
}

// Uso do padrão Command
public class Command {
    public static void main(String[] args) {
        Editor editor = new Editor();
        CommandInterface copyCommand = new CopyCommand(editor);
        CommandInterface pasteCommand = new PasteCommand(editor);
        CommandInterface undoCommand = new UndoCommand(editor);

        CommandInvoker invoker = new CommandInvoker();

        invoker.executeCommand(copyCommand);
        invoker.executeCommand(pasteCommand);
        invoker.executeCommand(undoCommand);
    }
}