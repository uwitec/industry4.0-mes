/**
 * ***************************************************************************
 * Copyright (c) 2018 RiceFish Limited
 * Project: SmartMES
 * Version: 1.6
 *
 * This file is part of SmartMES.
 *
 * SmartMES is Authorized software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation; either version 3 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * ***************************************************************************
 */
package com.qcadoo.mes.materialFlowMultitransfers.hooks;

import static com.qcadoo.mes.materialFlowMultitransfers.constants.TransferTemplateFields.LOCATION_FROM;
import static com.qcadoo.mes.materialFlowMultitransfers.constants.TransferTemplateFields.LOCATION_TO;

import org.springframework.stereotype.Service;

import com.qcadoo.model.api.DataDefinition;
import com.qcadoo.model.api.Entity;

@Service
public class TransferTemplateModelValidators {

    public boolean checkIfOneOfLocationsIsNotNull(final DataDefinition transferTemplateDD, final Entity transferTemplate) {
        Entity locationFrom = transferTemplate.getBelongsToField(LOCATION_FROM);
        Entity locationTo = transferTemplate.getBelongsToField(LOCATION_TO);

        if ((locationFrom == null) && (locationTo == null)) {
            transferTemplate.addError(transferTemplateDD.getField(LOCATION_FROM),
                    "materialFlow.validate.global.error.fillAtLeastOneLocation");
            transferTemplate.addError(transferTemplateDD.getField(LOCATION_TO),
                    "materialFlow.validate.global.error.fillAtLeastOneLocation");

            return false;
        }

        return true;
    }

}
