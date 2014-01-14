/*
    This file is part of RouteConverter.

    RouteConverter is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    RouteConverter is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with RouteConverter; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Copyright (C) 2007 Christian Pesch. All Rights Reserved.
*/

package slash.navigation.download;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Acts as a {@link TableModel} for the {@link Download}s of the {@link DownloadManager}.
 *
 * @author Christian Pesch
 */

public class DownloadTableModel extends AbstractTableModel {
    private List<Download> downloads = new ArrayList<Download>();

    public void setDownloads(List<Download> downloads) {
        this.downloads = downloads;
        fireTableDataChanged();
    }

    public int getRowCount() {
        return downloads.size();
    }

    public int getColumnCount() {
        return 2;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return getDownload(rowIndex);
    }

    public Download getDownload(int rowIndex) {
        return downloads.get(rowIndex);
    }

    void addDownload(Download download) {
        if (!downloads.add(download))
            throw new IllegalArgumentException("Download " + download + " not added to " + downloads);

        int index = downloads.indexOf(download);
        if (index == -1)
            throw new IllegalArgumentException("Download " + download + " not found in " + downloads);

        fireTableRowsInserted(index, index);
    }

    void updateDownload(Download download) {
        int index = downloads.indexOf(download);
        if (index == -1)
            throw new IllegalArgumentException("Download " + download + " not found in " + downloads);
        fireTableRowsUpdated(index, index);
    }

    void removeDownload(Download download) {
        int index = downloads.indexOf(download);
        if (index == -1)
            throw new IllegalArgumentException("Download " + download + " not found in " + downloads);

        if (!downloads.remove(download))
            throw new IllegalArgumentException("Download " + download + " not removed from " + downloads);

        fireTableRowsDeleted(index, index);
    }

}