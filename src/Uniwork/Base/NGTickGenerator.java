package Uniwork.Base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class NGTickGenerator {

    protected Timer FTimer;
    protected ArrayList<NGTickItem> FItems;
    protected Integer FBaseInterval;

    protected synchronized void DoTick() {
        Iterator lItr = FItems.iterator();
        while(lItr.hasNext())  {
            ((NGTickItem)lItr.next()).Tick();
        }
    }

    protected NGTickItem GetItem(String aName) {
        NGTickItem lResult = null;
        Iterator lItr = FItems.iterator();
        while(lItr.hasNext())  {
            lResult = (NGTickItem)lItr.next();
            if (lResult.getName().equals(aName))
                break;
            else
                lResult = null;
        }
        return lResult;
    }

    public NGTickGenerator() {
        FItems = new ArrayList<NGTickItem>();
        FTimer = new Timer();
        FBaseInterval = 10;
    }

    public NGTickGenerator(Integer aBaseInterval) {
        FItems = new ArrayList<NGTickItem>();
        FTimer = new Timer();
        FBaseInterval = aBaseInterval;
    }

    public void Initialize() {
        TimerTask lTimerTask = new TimerTask() {
            public void run() {
                synchronized (this) {
                    DoTick();
                }
            }
        };
        FTimer.schedule(lTimerTask,100,FBaseInterval);
    }

    public void Finalize() {
        FTimer.cancel();
        FTimer = null;
    }

    public void NewItem(String aName, Integer aInterval) {
        NGTickItem lTickItem = new NGTickItem(aName, aInterval);
        FItems.add(lTickItem);
    }

    public void SetItemEnabled(String aName, Boolean aValue) {
        NGTickItem lTickItem = GetItem(aName);
        lTickItem.setEnabled(aValue);
    }

    public Boolean GetItemEnabled(String aName) {
        NGTickItem lTickItem = GetItem(aName);
        return lTickItem.getEnabled();
    }

    public void SetItemInterval(String aName, Integer aValue) {
        NGTickItem lTickItem = GetItem(aName);
        lTickItem.setInterval(aValue);
    }

    public Integer GetItemInterval(String aName) {
        NGTickItem lTickItem = GetItem(aName);
        return lTickItem.getInterval();
    }

    public synchronized void addListener(String aName, NGTickListener aListener)  {
        NGTickItem lTickItem = GetItem(aName);
        lTickItem.addTickListener(aListener);
    }

    public synchronized void removeListener(String aName, NGTickListener aListener)   {
        NGTickItem lTickItem = GetItem(aName);
        lTickItem.addTickListener(aListener);
    }

    public void SetAllEnabled(Boolean aValue) {
        Iterator lItr = FItems.iterator();
        while(lItr.hasNext())  {
            NGTickItem lItem = (NGTickItem)lItr.next();
            lItem.setEnabled(aValue);
        }
    }

    public void ToggleAllEnabled( ) {
        Iterator lItr = FItems.iterator();
        while(lItr.hasNext())  {
            NGTickItem lItem = (NGTickItem)lItr.next();
            lItem.setEnabled(!lItem.getEnabled());
        }
    }

}

