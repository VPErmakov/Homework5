import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Task3 {
    ReentrantReadWriteLock note = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.WriteLock w = note.writeLock();
    ReentrantReadWriteLock.ReadLock r = note.readLock();
    public final List<String> notes = new ArrayList<String>();

    public void addNote(int index, String note) {
        w.lock();
        try {
            System.out.println("Добавление заметки [" + note + "] на позицию " + index);
            notes.add(index, note);
            System.out.println("Уже добавлена заметка [" + note + "]");
            w.unlock();
        }
        finally {
            w.unlock();
        }
    }

    public void removeNote(int index) {
        w.lock();
        try {
            System.out.println("Удаление заметки с позиции " + index);
            String note;
            note = notes.remove(index);
            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        } finally {
            w.unlock();
        }
    }

    public void readNote(int index)
    {
        r.lock();
        try {
            System.out.println("Чтение заметки с позиции " + index);
            String note;
            note = notes.get(index);
            System.out.println("Прочтена заметка [" + note + "] с позиции " + index);
            r.lock();
        } finally {
            r.unlock();
        }
    }
}
