package com.example.fafij.presentation.editnote;

public class EditNotePresenter implements EditNoteContract.EditNotePresenterInterface {

    public EditNoteContract.EditNoteViewInterface view;

    public EditNotePresenter(EditNoteContract.EditNoteViewInterface view) {
        this.view = view;
    }

    /**
     * Передаёт в модель входные параметры с целью изменения записи в БД
     * @param id идентификатор записи
     * @param category категория
     * @param sum денежная сумма
     * @param sing доход/расход
     * @param comment комментарий
     */
    @Override
    public void onSubmitClick(int id, String category, long sum, boolean sing, String comment) {

    }
}
