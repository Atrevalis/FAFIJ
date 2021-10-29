package com.example.fafij.presentation.addnote;

public class AddNotePresenter implements AddNoteContract.AddNotePresenterInterface {

    public AddNoteContract.AddNoteViewInterface view;

    public AddNotePresenter(AddNoteContract.AddNoteViewInterface view) {
        this.view = view;
    }


    /**
     * Передаёт в модель входные параметры с целью создания записи в БД
     * @param category категория
     * @param sum денежная сумма
     * @param sing доход/расход
     * @param comment комментарий
     */
    @Override
    public void onAddClick(String category, long sum, boolean sing, String comment) {

    }
}
