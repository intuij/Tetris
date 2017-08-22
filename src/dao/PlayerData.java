package dao;

import java.util.List;

import data.PlayerRecord;

public interface PlayerData {
	public List<PlayerRecord> loadRecord();
	public void saveRecord(List<PlayerRecord> list);
}
