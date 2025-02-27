import java.util.Stack;

// Memento
class TextMemento {
    private final String text;

    public TextMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Originator
class TextEditor {
    private String text = "";

    public void write(String newText) {
        text += newText;
    }

    public TextMemento save() {
        return new TextMemento(text);
    }

    public void restore(TextMemento memento) {
        this.text = memento.getText();
    }

    public void show() {
        System.out.println("Contenido actual: " + text);
    }
}

// Caretaker
class History {
    private Stack<TextMemento> mementos = new Stack<>();

    public void add(TextMemento memento) {
        mementos.push(memento);
    }

    public TextMemento undo() {
        if (!mementos.isEmpty()) {
            return mementos.pop();
        }
        return null;
    }
}

// Prueba del patrón Memento
public class MementoPatternDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hola, ");
        history.add(editor.save());

        editor.write("Como estas?");
        history.add(editor.save());

        editor.show();

        TextMemento memento = history.undo();
        if (memento != null) {
            editor.restore(memento);
        }
        editor.show();
    }
}
