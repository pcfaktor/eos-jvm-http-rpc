/**
 * Copyright 2013-present memtrip LTD.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.memtrip.eos.http.rpc

import com.memtrip.eos.http.rpc.model.account.request.AccountName
import com.memtrip.eos.http.rpc.model.account.response.Account
import com.memtrip.eos.http.rpc.model.block.request.BlockNumOrId
import com.memtrip.eos.http.rpc.model.block.response.Block
import com.memtrip.eos.http.rpc.model.block.response.BlockHeaderState
import com.memtrip.eos.http.rpc.model.contract.request.AbiBinToJson
import com.memtrip.eos.http.rpc.model.contract.request.GetCodeByAccountName
import com.memtrip.eos.http.rpc.model.contract.request.GetCurrencyBalance
import com.memtrip.eos.http.rpc.model.contract.request.GetCurrencyStats
import com.memtrip.eos.http.rpc.model.contract.request.GetTableRows
import com.memtrip.eos.http.rpc.model.contract.response.AbiForAccount
import com.memtrip.eos.http.rpc.model.contract.response.BinaryHex
import com.memtrip.eos.http.rpc.model.contract.response.CodeForAccount
import com.memtrip.eos.http.rpc.model.contract.response.ContractTableRows
import com.memtrip.eos.http.rpc.model.contract.response.RawCodeForAccount
import com.memtrip.eos.http.rpc.model.info.Info
import com.memtrip.eos.http.rpc.model.producer.request.GetProducers
import com.memtrip.eos.http.rpc.model.producer.response.ProducerList
import com.memtrip.eos.http.rpc.model.signing.GetRequiredKeysBody
import com.memtrip.eos.http.rpc.model.signing.PushTransaction
import com.memtrip.eos.http.rpc.model.signing.RequiredKeys
import com.memtrip.eos.http.rpc.model.transaction.response.TransactionCommitted
import io.reactivex.Single
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ChainApi {

    @POST("v1/chain/get_info")
    fun getInfo(): Single<Response<Info>>

    @POST("v1/chain/get_producers")
    fun getProducers(@Body body: GetProducers): Single<Response<ProducerList>>

    @POST("v1/chain/get_block")
    fun getBlock(@Body body: BlockNumOrId): Single<Response<Block>>

    @POST("v1/chain/get_block_header_state")
    fun getBlockHeaderState(@Body body: BlockNumOrId): Single<Response<BlockHeaderState>>

    @POST("v1/chain/get_account")
    fun getAccount(@Body body: AccountName): Single<Response<Account>>

    @POST("v1/chain/get_abi")
    fun getAbi(@Body body: AccountName): Single<Response<AbiForAccount>>

    @POST("v1/chain/get_code")
    fun getCode(@Body body: GetCodeByAccountName): Single<Response<CodeForAccount>>

    @POST("v1/chain/get_raw_code_and_abi")
    fun getRawCodeAndAbi(@Body body: AccountName): Single<Response<RawCodeForAccount>>

    @POST("v1/chain/get_table_rows")
    fun getTableRows(@Body body: GetTableRows): Single<Response<ContractTableRows>>

    @POST("v1/chain/get_currency_balance")
    fun getCurrencyBalance(@Body body: GetCurrencyBalance): Single<Response<List<String>>>

    @POST("v1/chain/abi_json_to_bin")
    fun abiJsonToBin(@Body body: RequestBody): Single<Response<BinaryHex>>

    @POST("v1/chain/abi_bin_to_json")
    fun abiBinToJson(@Body body: AbiBinToJson): Single<Response<ResponseBody>>

    @POST("v1/chain/get_required_keys")
    fun getRequiredKeys(@Body body: GetRequiredKeysBody): Single<Response<RequiredKeys>>

    @POST("v1/chain/get_currency_stats")
    fun getCurrencyStats(@Body body: GetCurrencyStats): Single<Response<ResponseBody>>

    @POST("v1/chain/push_transaction")
    fun pushTransaction(@Body body: PushTransaction): Single<Response<TransactionCommitted>>
}