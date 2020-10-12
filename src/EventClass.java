import java.util.ArrayList;

public class EventClass {
    private int x = 0;
    private int s;
    private ArrayList<ProgressListener> pLst
            = new ArrayList<>();
    private ArrayList<ResultListener> rLst
            = new ArrayList<>();

    public EventClass(int x){
        this.x = x;
    }

    public void addProgressListener(ProgressListener l){
        pLst.add(l);
    }

    public void addResultListener(ResultListener l){
        rLst.add(l);
    }

    public void removeProgressListener(ProgressListener l){
        pLst.remove(l);
    }

    public void removeResultListener(ResultListener l){
        rLst.remove(l);
    }

    public void calc(){
        s = 0;
        for (int i = 1; i<x; i++){
            s += i;
            //Сообщить о получении промежуточной суммы
            for (int j = 0; j<pLst.size(); j++)
                pLst.get(j).showProgress(s, i);

        }
        //Сообщить о получении итогового значения
        for (var l : rLst)
            l.showResult(s);
    }
}
